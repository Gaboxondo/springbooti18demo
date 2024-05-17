package com.mashosoft.i18demo.config.exceptionHandling.handler;

import com.mashosoft.i18demo.config.exceptionHandling.handler.model.ControlledErrorResponse;
import com.mashosoft.i18demo.config.exceptionHandling.model.BaseExceptionWithTranslation;
import com.mashosoft.i18demo.config.i18.Translator;
import com.mashosoft.i18demo.interfaces.web.requestAspect.AspectConstants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Objects;

@ControllerAdvice
@RestController
public class MainControllerExceptionHandler {

    private final Logger LOGGER = LoggerFactory.getLogger( MainControllerExceptionHandler.class);

    @Autowired private Translator translator;

    @Value("${spring.application.name:unknown}")
    private String appname;


    @ExceptionHandler(BaseExceptionWithTranslation.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ControlledErrorResponse handleException(BaseExceptionWithTranslation ex) {
        String requestKey = "No request";
        if(StringUtils.isNoneEmpty( MDC.get( AspectConstants.REQUEST_KEY))){
            requestKey = MDC.get( AspectConstants.REQUEST_KEY);
        }
        String errorMessage = translator.translateCode( ex.getErrorCode(), ex.getParameters() );
        return new ControlledErrorResponse(ex.getErrorCode(),errorMessage,requestKey);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ControlledErrorResponse handleException(HttpRequestMethodNotSupportedException ex) {
        String errorMessage = "Wrong Http Method when calling " + ex.getMethod() + ", right method is " + Arrays.toString( Objects.requireNonNull( ex.getSupportedMethods() ) );
        if(appname == null || appname.isBlank()){
            appname = "AppNameNotSet";
        }
        return new ControlledErrorResponse( "error." + appname + ".http.method.00",errorMessage,null );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ControlledErrorResponse handleException(HttpMessageNotReadableException ex) {
        if(appname == null || appname.isBlank()){
            appname = "AppNameNotSet";
        }
        String errorMessage = "Wrong Body in the request, please check the API definition";
        return new ControlledErrorResponse( "error." + appname + ".httpBody.00",errorMessage,null);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ControlledErrorResponse handleException(MethodArgumentNotValidException ex) {
        if(appname == null || appname.isBlank()){
            appname = "AppNameNotSet";
        }
        return new ControlledErrorResponse( "error." + appname + ".http.arguments.00", "Not Valid Argument " + ex.getParameter(), null);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ControlledErrorResponse handleException(Exception ex) {
        LOGGER.error( "context: ",ex );
        if(appname == null || appname.isBlank()){
            appname = "AppNameNotSet";
        }
        return new ControlledErrorResponse( "error." + appname + ".generic","Es ist ein Fehler aufgetreten. Bitte kontaktieren Sie den Support.", null);
    }
}
