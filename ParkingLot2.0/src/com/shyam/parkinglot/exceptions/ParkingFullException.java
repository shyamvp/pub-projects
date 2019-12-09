package com.shyam.parkinglot.exceptions;

public class ParkingFullException extends Exception {
	
	private static final long serialVersionUID = -3552275262672621625L;

	private String errorCode = null;
	private Object[] errorParameters = null;

	public ParkingFullException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public ParkingFullException(String message) {
		super(message);
	}

	public ParkingFullException(Throwable throwable) {
		super(throwable);
	}

	public ParkingFullException(String errorCode, String message, Object[] errorParameters) {
		super(message);
		this.setErrorCode(errorCode);
		this.setErrorParameters(errorParameters);
	}

	public ParkingFullException(String errorCode, String message, Throwable throwable) {
		super(message, throwable);
		this.setErrorCode(errorCode);
	}

	public ParkingFullException(String errorCode, String message, Object[] errorParameters, Throwable throwable) {
		super(message, throwable);
		this.setErrorCode(errorCode);
		this.setErrorParameters(errorParameters);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public Object[] getErrorParameters() {
		return errorParameters;
	}

	public void setErrorParameters(Object[] errorParameters) {
		this.errorParameters = errorParameters;
	}
}
