package com.mashosoft.i18demo.config.exceptionHandling.model.exception;



import com.mashosoft.i18demo.config.exceptionHandling.model.BaseErrorCode;
import com.mashosoft.i18demo.config.exceptionHandling.model.BaseExceptionWithTranslation;

public class ControlledErrorExceptionWithTranslation extends BaseExceptionWithTranslation {
    public ControlledErrorExceptionWithTranslation(BaseErrorCode errorCode) {
        super( errorCode );
    }

    public ControlledErrorExceptionWithTranslation(BaseErrorCode errorCode, Object[] parameters) {
        super( errorCode, parameters );
    }

}
