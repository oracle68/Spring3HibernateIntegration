package com.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.dao.AddressDao;
import com.myapp.entity.Address;



@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressDao addressDao;

	@Override
    @Transactional
	public void insertData(Address address) {
		addressDao.insertData(address);
	}

	@Override
    @Transactional
	public List<Address> getAddressList() {
		return addressDao.getAddressList();
	}

	@Override
        @Transactional
	public void deleteData(Integer id) {
		addressDao.deleteData(id);
		
	}

	@Override
    @Transactional
	public Address getAddress(Integer id) {
		return addressDao.getAddress(id);
	}

	@Override
    @Transactional
	public void updateData(Address address) {
		addressDao.updateData(address);
		
	}
	@Override
    @Transactional	
	public Address getAddressByCustomerId(Integer id) {
		return addressDao.getAddressByCustomerId(id);
	}	

	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}
	
}

