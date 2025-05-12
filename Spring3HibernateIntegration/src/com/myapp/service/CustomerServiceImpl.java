package com.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.dao.CustomerDao;
import com.myapp.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;

	@Override
    @Transactional
	public void insertData(Customer customer) {
		customerDao.insertData(customer);
	}

	@Override
    @Transactional
	public List<Customer> getCustomerList() {
		return customerDao.getCustomerList();
	}

	@Override
    @Transactional
	public void deleteData(Integer id) {
		customerDao.deleteData(id);
		
	}

	@Override
    @Transactional
	public Customer getCustomer(Integer id) {
		return customerDao.getCustomer(id);
	}

	@Override
    @Transactional
	public void updateData(Customer customer) {
		customerDao.updateData(customer);
		
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
}