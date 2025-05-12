package com.myapp.service;

import java.util.List;

import com.myapp.entity.Address;



public interface AddressService {

	public void insertData(Address address);

	public List<Address> getAddressList();

	public void deleteData(Integer id);

	public Address getAddress(Integer id);

	public void updateData(Address address);
	
	public Address getAddressByCustomerId(Integer id);	

}
