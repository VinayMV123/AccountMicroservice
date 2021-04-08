package com.amisign.accountservice.common;

public class CustomException extends RuntimeException {
    private static final long serialVersionUID = 1783119999453448531L;
    private String message;


    public CustomException(String message) {
        super();
        this.message = message;
    }

    /**
     *
     */

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}