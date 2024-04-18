package com.mashosoft.i18demo.domain.errorCodes;

import com.mashosoft.i18demo.config.exceptionHandling.model.BaseErrorCode;

public enum ErrorCodes implements BaseErrorCode {
    ID_NOT_FOUND("error.code." + "01"),
    ;

    ErrorCodes(String errorCode) {
        this.errorCode = errorCode;
    }

    private final String errorCode;

    @Override
    public String getCode() {
        return errorCode;
    }

}
