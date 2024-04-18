package com.mashosoft.i18demo.config.exceptionHandling.handler.model;

import lombok.Data;

@Data
public class ExceptionDTO {

    public ExceptionDTO(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String errorCode;

    public String errorMessage;


}
