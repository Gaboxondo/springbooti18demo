package com.mashosoft.i18demo.interfaces.web.requestAspect;

import com.mashosoft.i18demo.config.exceptionHandling.model.BaseExceptionWithTranslation;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RequestAspectUtils {

    private static String appName;

    @Value("${spring.application.name:unknown}")
    public void setappName(String appName) {
        RequestAspectUtils.appName = appName;
    }

    static String generateInputTrace(String controllerName,String controllerMethodName, String method, Object[] args,
        CodeSignature codeSignature) {
        if (args != null && args.length > 0) {
            // When input parameters
            String arguments = generateArgments(args, codeSignature);

            return AspectConstants.CONTROLLER + controllerName + " " + AspectConstants.CONTROLLER_IN + " " +
                   AspectConstants.SERVICE_NAME + controllerMethodName  + " " + AspectConstants.METHOD + method +
                   " " + AspectConstants.ARG + arguments;
        } else {
            // When no input parameters

            return AspectConstants.CONTROLLER + controllerName + " "+ AspectConstants.CONTROLLER_IN + " " +
                   AspectConstants.SERVICE_NAME + controllerMethodName + " " +  AspectConstants.METHOD + method;
        }
    }

    static String generateOutputErrorTrace(String controllerName,String controllerMethodName, String method, Throwable exception) {
        if (exception instanceof BaseExceptionWithTranslation) {
            // When controlled error
            BaseExceptionWithTranslation e = (BaseExceptionWithTranslation) exception;
            String result = AspectConstants.CONTROLLER_ERROR;

            return AspectConstants.CONTROLLER + controllerName + " " + AspectConstants.CONTROLLER_OUT + " " +
                   AspectConstants.SERVICE_NAME + controllerMethodName + " " + AspectConstants.METHOD + method + " " +
                   AspectConstants.RESULT + result + " " + AspectConstants.ERROR_CODE + e.getErrorCode();
        } else {
            // When not controlled error
            String result = AspectConstants.GENERIC_ERROR;

            return AspectConstants.CONTROLLER + controllerName + " " + AspectConstants.CONTROLLER_OUT + " " +
                   AspectConstants.SERVICE_NAME + controllerMethodName + " " + AspectConstants.METHOD + method + " " +
                   AspectConstants.RESULT + result + " " + AspectConstants.ERROR_MSG + exception.getMessage();
        }
    }

    static String generateOutputTrace(String controllerName,String controllerMethodName, String method, Long duration) {

        // When response is OK
        String result = AspectConstants.OK;

        return AspectConstants.CONTROLLER + controllerName + " " + AspectConstants.CONTROLLER_OUT + " " +
               AspectConstants.SERVICE_NAME + controllerMethodName + " " + AspectConstants.METHOD + method + " " +
               AspectConstants.RESULT + result + " " + AspectConstants.DURATION + duration;
    }

    // -----------------------------------------------------------------------------------------------------------------

    private static String generateArgments(Object args[], CodeSignature codeSignature) {
        StringBuilder arguments = new StringBuilder("[");
        for (int i = 0; i < args.length; i++) {
            String argument = codeSignature.getParameterNames()[i] + "=" + args[i] + " ";
            arguments.append(argument);
        }
        String parametersString = arguments.toString();
        parametersString = parametersString.substring(0, parametersString.length() - 1);
        parametersString = parametersString + "]";
        return parametersString;
    }
}
