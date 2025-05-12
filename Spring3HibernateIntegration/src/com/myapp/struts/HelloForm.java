package com.myapp.struts;

import java.util.Date;

import org.apache.struts.action.ActionForm;

public class HelloForm extends ActionForm{
	

	private static final long serialVersionUID = 1L;
	String data ;
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

