package com.myapp.dao;

import java.util.List;

import com.myapp.entity.Customer;



public interface CustomerDao {

	public void insertData(Customer customer);
	public List<Customer> getCustomerList();
	public void updateData(Customer customer);
	public void deleteData(Integer id);
	public Customer getCustomer(Integer id);

	
}
