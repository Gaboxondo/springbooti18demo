package com.mashosoft.i18demo.config.exceptionHandling.model.exception;



import com.mashosoft.i18demo.config.exceptionHandling.model.BaseErrorCode;
import com.mashosoft.i18demo.config.exceptionHandling.model.BaseExceptionWithTranslation;

public class BussinessExceptionWithTranslation extends BaseExceptionWithTranslation {
    public BussinessExceptionWithTranslation(BaseErrorCode errorCode) {
        super( errorCode );
    }

    public BussinessExceptionWithTranslation(BaseErrorCode errorCode, Object[] parameters) {
        super( errorCode, parameters );
    }

}
