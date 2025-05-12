package com.myapp.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myapp.dto.CustomerDTO;
import com.myapp.entity.Address;
import com.myapp.entity.Customer;
import com.myapp.service.AddressService;
import com.myapp.service.CustomerService;


@Controller
public class CustomerController {

	final static Logger log = Logger.getLogger(CustomerController.class);
	
    @Autowired
	private CustomerService customerService;
    
    @Autowired
	private AddressService addressService;
    
	@RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
	public ModelAndView getCustomerId (@PathVariable("customerId") Integer customerId) {
	 
     Integer err=0;
     String messageError="";
     String message="";
	 try {	
	 Customer customer = customerService.getCustomer(customerId); //Entity
	 log.debug ("***************************Customer Loaded OK ");
	 
	 Address address = addressService.getAddressByCustomerId(customerId); //Entity
	 log.debug ("***************************Address Loaded OK ");
	 //Create dto
	 CustomerDTO dto = new CustomerDTO();
	 dto.setAddress(address.getAddress());
	 dto.setCountry(address.getCountry());
	 dto.setZipCode(address.getZipCode());
	 dto.setFullName(customer.getFirstname() + " " + customer.getLastname());
	 dto.setId(customer.getId());
	 message = dto.toString();
	 } catch (Exception ex) { 
		  err=1;
		  //messageError=ex.getMessage();
		  //messageError+=ex.getLocalizedMessage();
		  messageError+=ex.toString();

		  }
	 //Return DTO
	 //return Response.ok(dto, MediaType.APPLICATION_JSON).build();
	 if (err==1) { return new ModelAndView ("error", "message", messageError); }
	 else 
 	   {return new ModelAndView("customerinfo", "message", message); }	
  }

}	