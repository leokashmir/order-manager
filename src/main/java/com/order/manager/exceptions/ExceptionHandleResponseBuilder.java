package com.order.manager.exceptions;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExceptionHandleResponseBuilder {

    @Value("${application.version}")
    private String version;

    public ExceptionHandleResponse getExceptionHandleResponse(Integer httpCode, String message){
        return ExceptionHandleResponse.builder()
                .apiVersion(version)

                .error(ErrorHandle.builder()
                        .httpCode(httpCode.toString())
                        .errorCode("API-addresses-"+httpCode)
                        .message(message)
                        .build())
                .build();
    }


}
