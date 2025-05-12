package com.myapp.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name="customer")
public class Customer {
 @Id
 @GeneratedValue(strategy= GenerationType.IDENTITY)
 private Integer id;
 @Column(name="firstname")
 private String firstname;
 @Column(name="lastname")
 private String lastname;
 @Column(name="password")
 private String password;
 
	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="customer")
	private List<Address> addresses;

	public Customer() {
	}
	
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", password=" + password
			+ "]";
}
 

 
}