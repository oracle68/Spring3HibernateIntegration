package com.myapp.dao;

import java.util.List;

import com.myapp.entity.Address;

public interface AddressDao {
	public void insertData(Address address);
	public List<Address> getAddressList();
	public void updateData(Address address);
	public void deleteData(Integer id);
	public Address getAddress(Integer id);
	public Address getAddressByCustomerId(Integer id);
	
}
