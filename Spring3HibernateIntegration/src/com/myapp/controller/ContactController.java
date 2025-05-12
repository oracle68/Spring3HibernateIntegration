package com.myapp.controller;

import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myapp.entity.Contact;
import com.myapp.service.ContactService;
import com.myapp.validator.ContactValidator;

@Controller
//@SessionAttributes("contact")
public class ContactController {
     final static Logger log = Logger.getLogger(ContactController.class);
 
	@Autowired
	private ContactService contactService;
	@Autowired
	private ContactValidator contactValidator;	

	/*@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(contactValidator);
	}*/
	
	@RequestMapping(value="/contactList", method = RequestMethod.GET)
	public ModelAndView listContacts() {

  
		return new ModelAndView("contactList", "contactList", contactService.listContact());
	}
	
	@RequestMapping(value="contact", method = RequestMethod.GET)
	public ModelAndView NewContact() {


		return new ModelAndView( "contact","contact", new Contact());
	}

	@RequestMapping(value="contact",method = RequestMethod.POST)
	public ModelAndView submitForm (@Valid Contact contact, BindingResult result) //, Model model) 
	{
		//public String submitForm(@ModelAttribute("contact") Contact contact,BindingResult result, SessionStatus status)

		/*DataBinder binder = new DataBinder(contact);
		binder.setValidator(contactValidator);
		binder.validate();
		BindingResult result = binder.getBindingResult();
		*/
		contactValidator.validate(contact, result);


		
		if (result.hasErrors() || contact.getNom().equals("") || contact.getCognom().equals(""))
		{
  
			log.debug("ERRORS **********************************************");
			log.debug( contact.toString());
			log.debug("ERRORS **********************************************");
			
			return new ModelAndView( "contact","contact", contact);
			
		}	
		
		else  //if (contact.getNom()!=null)
		{ contactService.addContact(contact);}
 
			
		  //Mark Session Complete
	    //status.setComplete();
		
		return new ModelAndView("contactList", "contactList", contactService.listContact());
	}

	@RequestMapping(value="/borrar/{cId}")
	public String deleteContact(@PathVariable("cId") Integer cId) {

		contactService.removeContact(cId);

		return "redirect:/contactList";
	}
        

}

