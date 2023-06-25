package com.prueba.backwebsimilar.exception;

import lombok.Generated;

public class CustomException extends RuntimeException {
    private Integer errorCode;

    public CustomException (String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public CustomException (String message) {
        super(message);
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }
}
