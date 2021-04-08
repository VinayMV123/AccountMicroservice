package com.amisign.accountservice.common;

import lombok.Getter;

import java.util.List;

@Getter
public class BadRequestException extends RuntimeException {

    private List<ErrorData> errorDetails;

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, List<ErrorData> errorDetails) {
        super(message);
        this.errorDetails = errorDetails;
    }

}
