package com.mashosoft.i18demo.interfaces.web.requestAspect;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.UUID;


//All clases in this package should be moved to a library and also
@Component
@Aspect
@Import( RequestAspectUtils.class )
@ConditionalOnProperty(name = "requestsLogger.enable", havingValue = "true", matchIfMissing = true)
public class RequestAspectLog {

    @Value("${spring.application.name:unknown}")
    String appName;

    private final Logger LOGGER = LoggerFactory.getLogger( RequestAspectLog.class);

    @Pointcut("@annotation(io.swagger.v3.oas.annotations.Operation)")
    public void requestPointcut() {}

    @Around("requestPointcut()")
    public Object logging(final ProceedingJoinPoint joinPoint) throws Throwable {

        // Method Parameters Gets
        Object[] args = joinPoint.getArgs();
        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
        HttpServletRequest request =
            ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        // Request Key Generation
        MDC.put( AspectConstants.MICROSERVICE, appName );
        if(request.getHeader( "requestKey" ) != null) {
            MDC.put( AspectConstants.REQUEST_KEY, request.getHeader( "requestKey" ) );
        } else {
            String requestKey = UUID.randomUUID().toString();
            MDC.put( AspectConstants.REQUEST_KEY, requestKey );
        }

        String method = request.getMethod();
        String controllerMethodName = joinPoint.getSignature().getName();
        String[] packageParts = joinPoint.getSignature().getDeclaringTypeName().split( "\\." );
        String controllerName = packageParts[packageParts.length -1];

        // Input Trace print
        String inputTrace =
            RequestAspectUtils.generateInputTrace(controllerName,controllerMethodName, method, args, codeSignature );
        if(!isExcludedOpenAPIController(controllerName)) {
            LOGGER.info( inputTrace );
        }

        // Watch to check the responses times
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        try {
            Object httpResponse = joinPoint.proceed();

            // If OK, get the service duration
            stopWatch.stop();
            Long duration = stopWatch.getTotalTimeMillis();

            // Output Ok trace
            String outputTrace =
                RequestAspectUtils.generateOutputTrace(
                    controllerName,controllerMethodName, method, duration );
            if(!isExcludedOpenAPIController(controllerName)) {
                LOGGER.info( outputTrace );
            }

            return httpResponse;

        } catch (Throwable e) {
            // Output Error trace
            String errorOutPutTrace =
                RequestAspectUtils.generateOutputErrorTrace(
                    controllerName,controllerMethodName, method, e );
            if(!isExcludedOpenAPIController(controllerName)) {
                LOGGER.error( errorOutPutTrace );
            }

            throw e;
        }
    }

    private Boolean isExcludedOpenAPIController(String controllerName){
        if(controllerName == null || controllerName.isEmpty()){
            return false;
        }

        if(controllerName.equals( "SwaggerConfigResource" ) || controllerName.equals( "MultipleOpenApiWebMvcResource" )){
            return true;
        }

        return false;
    }

}
