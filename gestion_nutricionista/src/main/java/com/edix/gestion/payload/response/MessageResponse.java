package com.edix.gestion.payload.response;

public class MessageResponse {
	
	private String message;

	public MessageResponse(String message) {
		super();
		this.message = message;
	}

	public MessageResponse() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
