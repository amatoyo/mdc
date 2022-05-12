package com.boorge.mdc.welcome;

public class Welcome {
	
	private String message;

	public Welcome(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Welcome [message=" + message + "]";
	}
	
	
}
