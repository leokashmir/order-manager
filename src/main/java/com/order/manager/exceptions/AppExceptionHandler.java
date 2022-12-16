package com.order.manager.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;
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

    /**
     * BeanValidator customização.
     * String fieldName = ((FieldError) error).getField();
     * String mens = error.getDefaultMessage()
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionHandleResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
    StringBuilder errors = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach((error) ->
            errors.append(error.getDefaultMessage()).append(" ")
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionHandleResponseBuilder.getExceptionHandleResponse(HttpStatus.BAD_REQUEST.value(), errors.toString()));
    }
}
