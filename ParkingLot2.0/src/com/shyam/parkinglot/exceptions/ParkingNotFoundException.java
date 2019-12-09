package com.shyam.parkinglot.exceptions;

public class ParkingNotFoundException extends Exception {

	private static final long serialVersionUID = 1449093540843961319L;

	private String errorCode = null;
	private Object[] errorParameters = null;

	public ParkingNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public ParkingNotFoundException(String message) {
		super(message);
	}

	public ParkingNotFoundException(Throwable throwable) {
		super(throwable);
	}

	public ParkingNotFoundException(String errorCode, String message, Object[] errorParameters) {
		super(message);
		this.setErrorCode(errorCode);
		this.setErrorParameters(errorParameters);
	}

	public ParkingNotFoundException(String errorCode, String message, Throwable throwable) {
		super(message, throwable);
		this.setErrorCode(errorCode);
	}

	public ParkingNotFoundException(String errorCode, String message, Object[] errorParameters, Throwable throwable) {
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
