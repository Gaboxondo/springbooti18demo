package com.mashosoft.i18demo.config.exceptionHandling.handler.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ControlledErrorResponse {

    public ControlledErrorResponse(String errorCode, String errorMessage, String requestKey) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.requestKey = requestKey;
    }

    public String errorCode;

    public String errorMessage;

    public String requestKey;


}
