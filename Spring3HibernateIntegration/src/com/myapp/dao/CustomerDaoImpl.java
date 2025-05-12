package com.myapp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao{

	   @Autowired
	   private SessionFactory sessionFactory;
		
	    @Override
		public void insertData(Customer customer) {
			this.sessionFactory.getCurrentSession().save(customer);
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<Customer> getCustomerList(){
			return this.sessionFactory.getCurrentSession().createQuery("from Customer").list();
		}

		@Override
		public void deleteData(Integer id) {
			Customer customer = (Customer) sessionFactory.getCurrentSession().load(Customer.class, id);
		        if (null != customer) {
	        	this.sessionFactory.getCurrentSession().delete(customer);
	        }
		}
		
		@Override
		public void updateData(Customer customer) {

	            this.sessionFactory.getCurrentSession().update(customer); 

		}

	        @Override
		public Customer getCustomer(Integer id) {
	        	Customer customer =(Customer) this.sessionFactory.getCurrentSession().get(Customer.class, id);
	            return customer;
	        }		

}
