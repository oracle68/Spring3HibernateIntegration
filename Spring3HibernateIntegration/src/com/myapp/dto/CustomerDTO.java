package com.myapp.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable{
	 

	private static final long serialVersionUID = 1L;
	private Integer id;
	 private String FullName;
	 private String country;
	 private String Address;
	 private String zipCode;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", FullName=" + FullName + ", country=" + country + ", Address=" + Address
				+ ", zipCode=" + zipCode + "]";
	}

	public  CustomerDTO ()
	{
		super();
	}
	public  CustomerDTO (Integer id,String fullName,String country,String address,String zipCode)
	 {
		 super();
		 this.id=id;
		 this.FullName=fullName;
		 this.country=country;
		 this.Address= address;
		 this.zipCode=zipCode;
	 }
	}
