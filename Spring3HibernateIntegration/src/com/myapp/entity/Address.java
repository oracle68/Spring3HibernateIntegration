package com.myapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="address")
public class Address {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long id;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="FK_CUSTOMER")
	private Customer customer;

	public Address() {
	}
 @Column(name="country")
 private String country;
 @Column(name="address")
 private String address;
 @Column(name="zipcode")
 private String zipCode;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getZipCode() {
	return zipCode;
}
public void setZipCode(String zipCode) {
	this.zipCode = zipCode;
}
@Override
public String toString() {
	return "Address [id=" + id + ", customer=" + customer + ", country=" + country + ", address=" + address
			+ ", zipCode=" + zipCode + "]";
}
 
 

 
}
