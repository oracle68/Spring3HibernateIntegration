package com.myapp.struts;

import java.math.BigDecimal;

import org.apache.struts.action.ActionForm;

public class ItemForm extends ActionForm {

	private String error;
	
	private String name;

	private String description;

	private String price;
	
	
    public void setError(String err) {
     	
    this.error =
        "<span style='color:red'>Campo vacio "+err+"</span>";
    }
     public String getError() {
        return error;
    }   
     
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
    public ItemForm() {
        super();
        // TODO Auto-generated constructor stub
    }	
	
}
