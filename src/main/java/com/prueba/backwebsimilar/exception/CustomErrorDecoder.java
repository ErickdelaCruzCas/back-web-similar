package com.prueba.backwebsimilar.exception;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {

        switch (response.status()){
            case 404:
                return new CustomException("Product Not Found", response.status());
            case 500:
                return new CustomException("A saber", response.status());
            default:
                return new CustomException(response.toString());
        }
    }
}
