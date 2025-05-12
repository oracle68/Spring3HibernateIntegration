package com.myapp.dao;

import java.util.List;

import org.apache.log4j.Logger;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.entity.Address;


@Repository
public class AddressDaoImpl implements AddressDao{
	final static Logger log = Logger.getLogger(AddressDaoImpl.class);
	
	   @Autowired
	   private SessionFactory sessionFactory;
		
	    @Override
		public void insertData(Address address) {
			this.sessionFactory.getCurrentSession().save(address);
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<Address> getAddressList(){
			return this.sessionFactory.getCurrentSession().createQuery("from Address").list();
		}

		@Override
		public void deleteData(Integer id) {
			Address address = (Address) sessionFactory.getCurrentSession().load(Address.class, id);
		        if (null != address) {
	        	this.sessionFactory.getCurrentSession().delete(address);
	        }
		}
		
		@Override
		public void updateData(Address address) {

	            this.sessionFactory.getCurrentSession().update(address); 

		}

	    @Override
		public Address getAddress(Integer id) {
	        	Address address =(Address) this.sessionFactory.getCurrentSession().get(Address.class, id);
	            return address;
	        }	
	    @Override
	    public Address getAddressByCustomerId(Integer id) {
            log.debug("********************************getAddressByCustomerId INI");
            Address address = (Address)  this.sessionFactory.getCurrentSession().createQuery("Select a from Address a where rownum=1 and a.customer.id=:id")
       			 .setParameter("id", id).list().get(0);

        	log.debug("********************************getAddressByCustomerId END");        	
            return address;
        }
}
