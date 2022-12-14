package com.order.manager.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import java.util.Objects;

@ControllerAdvice
public class AppExceptionHandler {

    @Autowired
    private ExceptionHandleResponseBuilder exceptionHandleResponseBuilder;

    @ExceptionHandler(value = {HttpClientErrorException.BadRequest.class})
    public ResponseEntity<ExceptionHandleResponse> handleConflictBadRequest(HttpClientErrorException exception, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionHandleResponseBuilder.getExceptionHandleResponse(exception.getStatusCode().value(), exception.getMessage()));
    }

    @ExceptionHandler(value = {HttpClientErrorException.NotFound.class})
    public ResponseEntity<ExceptionHandleResponse> handleConflictNotFound(HttpClientErrorException exception, WebRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionHandleResponseBuilder.getExceptionHandleResponse(exception.getStatusCode().value(), exception.getMessage()));
    }

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<ExceptionHandleResponse> handleGeneric(GenericException exception, WebRequest request) {
        if(Objects.nonNull(exception.getExceptionHandleResponse())){
            Integer httpStatus = Integer.valueOf(exception.getExceptionHandleResponse().getError().getHttpCode());
            return ResponseEntity.status(httpStatus).body(exception.getExceptionHandleResponse());
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionHandleResponseBuilder.getExceptionHandleResponse( HttpStatus.BAD_REQUEST.value() , exception.getCustomMessage()));
        }

    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ExceptionHandleResponse> handleThrowable(Throwable exception, WebRequest request) {

        if (exception instanceof GenericException) {
            GenericException ex = (GenericException) exception;
            return handleGeneric(ex, request);
        }
        if (exception instanceof NullPointerException){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionHandleResponseBuilder.getExceptionHandleResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionHandleResponseBuilder.getExceptionHandleResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage()));
    }
}
