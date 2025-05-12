package com.myapp.validator;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myapp.entity.Contact;


@Component
public class ContactValidator implements Validator {
    final static Logger log = Logger.getLogger(ContactValidator.class);
//which objects can be validated by this validator
	@Override
/*	 public boolean supports(Class clazz) {
        return Contact.class.isAssignableFrom(clazz);
    }
*/    
	public boolean supports(Class<?> paramClass) {
		return Contact.class.equals(paramClass);
	}   	
    @Override
    public void validate(Object obj, Errors errors) {
        
    	Contact contact = (Contact) obj;
    	log.debug("**********************************************");
		log.debug("Validate "+ contact.toString());
		log.debug("**********************************************");
    	if (contact.getNom().equals(""))
    	{	
            //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "error.camp");
    		 errors.rejectValue("nom", "error.nom","error camp buit");
    		//errors.rejectValue("nom", "error.nom", new Object[]{"'nom'"}, "nom can't be empty");
    	}

    	if (contact.getCognom().equals(""))
    	{	

           //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognom", "error.camp");
    	   errors.rejectValue("cognom", "error.cognom","error camp buit");
        }
    	if (contact.getMail().equals(""))
    	{	

           ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail", "error.mail");
    	   //errors.rejectValue("mail", "error.camp");
        }
    	if (contact.getTelefon().equals(""))
    	{	

    		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefon", "error.camp","camp obligatori");
    	   //errors.rejectValue("telefon", "error.camp");
        }

    }	
}