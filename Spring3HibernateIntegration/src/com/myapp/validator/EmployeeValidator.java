package com.myapp.validator;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myapp.entity.Contact;
import com.myapp.entity.Employee;

	@Component
	public class EmployeeValidator implements Validator {
	    final static Logger log = Logger.getLogger(EmployeeValidator.class);
	//which objects can be validated by this validator
		@Override
		public boolean supports(Class<?> paramClass) {
			return Employee.class.equals(paramClass);
		}    

	    @Override
	    public void validate(Object obj, Errors errors) {
	        //ValidationUtils.rejectIfEmpty(errors, "firstname", "required", "camp obligatori.");
	        //ValidationUtils.rejectIfEmpty(errors, "lastname", "required", "Field is required.");
	      //  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "user.firstname.required");
	      //  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "user.lastname.required");
	    	
	    	Employee em = (Employee) obj;
	    	log.debug("**********************************************");
			log.debug("Validate "+ em.toString());
			log.debug("**********************************************");
			 errors.rejectValue("lastname", "error.nom","error camp buit");
			 errors.rejectValue("firstname", "error.nom","error camp buit");
			 errors.rejectValue("email", "error.nom","error camp buit");

			 //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "error.nom");
			 //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "error.nom");
			 
/*	    	if (em.getFirstname().equals(""))
	    	{	
	            //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "error.camp");
	    		 errors.rejectValue("firstname", "error.nom","error camp buit");
	    		//errors.rejectValue("nom", "error.nom", new Object[]{"'nom'"}, "nom can't be empty");
	    	}	    	

	    	if (em.getLastname().equals(""))
	    	{	
	            //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "error.camp");
	    		 errors.rejectValue("lastname", "error.nom","error camp buit");
	    		//errors.rejectValue("nom", "error.nom", new Object[]{"'nom'"}, "nom can't be empty");
	    	}	    	
*/
	    }
	 }