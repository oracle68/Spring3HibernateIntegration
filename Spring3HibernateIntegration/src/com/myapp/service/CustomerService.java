package com.myapp.service;

import java.util.List;

import com.myapp.entity.Customer;



public interface CustomerService {

	public void insertData(Customer customer);

	public List<Customer> getCustomerList();

	public void deleteData(Integer id);

	public Customer getCustomer(Integer id);

	public void updateData(Customer customer);
}
