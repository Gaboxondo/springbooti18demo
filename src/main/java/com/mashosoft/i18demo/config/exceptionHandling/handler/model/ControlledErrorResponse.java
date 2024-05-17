package com.mashosoft.i18demo.config.exceptionHandling.handler.model;

import lombok.Data;

@Data
public class ControlledErrorResponse {

    public ControlledErrorResponse(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String errorCode;

    public String errorMessage;


}
