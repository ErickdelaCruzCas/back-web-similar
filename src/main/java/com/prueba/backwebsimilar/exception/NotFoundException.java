package com.prueba.backwebsimilar.exception;

import lombok.Generated;

public class NotFoundException extends RuntimeException {
    private Integer errorCode;

    public NotFoundException (String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public NotFoundException (String message) {
        super(message);
    }

    @Generated
    public Integer getErrorCode() {
        return this.errorCode;
    }
}
