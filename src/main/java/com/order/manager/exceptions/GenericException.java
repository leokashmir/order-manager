package com.order.manager.exceptions;


public class GenericException extends Exception {


	private static final long serialVersionUID = -7082212867266961646L;
	private String customMessage;
	private ErrorHandle errorHandle;
	private ExceptionHandleResponse exceptionHandleResponse;
	private Exception exception;


	public GenericException() {
		super();
	}
	public GenericException(String msg) {
		super(msg);
		this.customMessage = msg;

	}

	public GenericException(ExceptionHandleResponse err) {
		super();
		this.exceptionHandleResponse = err;
	}

	public GenericException(ErrorHandle err) {
		super();
		this.errorHandle = err;
	}

	public GenericException(String msg, Exception exception) {
		super(msg);
		this.exception = exception;
	}

	public GenericException(String msg, ExceptionHandleResponse err) {
		super(msg);
		this.customMessage = msg;
		this.exceptionHandleResponse = err;
	}

	public GenericException(String msg, ExceptionHandleResponse err, Exception exception) {
		super(msg);
		this.customMessage = msg;
		this.exceptionHandleResponse = err;
		this.exception = exception;
	}

	public String getCustomMessage() {
		return customMessage;
	}

	public ErrorHandle getErrorHandle() {
		return errorHandle;
	}

	public ExceptionHandleResponse getExceptionHandleResponse() {
		return exceptionHandleResponse;
	}

}
