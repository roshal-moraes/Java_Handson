package com.self.exceptions;

public class CustomException extends Exception{
	private String response;
	private String code;
	public CustomException(String response, String code) {
		super("CustomException occured");
		this.response = response;
		this.code = code;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	

}
