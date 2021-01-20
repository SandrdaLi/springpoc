package com.example.demo.exception;

public class ResponseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	protected ErrorResponse errorResponse;

	public ResponseException(ErrorResponse errorResponse) {
		super(errorResponse.getMsg());
		this.errorResponse = errorResponse;
	}

	public ResponseException(ErrorResponse errorResponse, Throwable cause) {
		super(errorResponse.getMsg(), cause);
		this.errorResponse = errorResponse;
	}

	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}
}
