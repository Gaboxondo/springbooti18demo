package com.mashosoft.i18demo.config.exceptionHandling.model;


public class BaseExceptionWithTranslation extends RuntimeException{

    private String errorCode;

    private Object[] parameters;

    public BaseExceptionWithTranslation(String errorCode){
        this.errorCode = errorCode;
    }

    public BaseExceptionWithTranslation(BaseErrorCode errorCode){
        this.errorCode = errorCode.getCode();
    }

    public BaseExceptionWithTranslation(BaseErrorCode errorCode, Object[] parameters){
        this.errorCode = errorCode.getCode();
        this.parameters = parameters;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
