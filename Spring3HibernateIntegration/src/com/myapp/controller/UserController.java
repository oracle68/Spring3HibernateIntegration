package com.myapp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.myapp.entity.City;
import com.myapp.entity.Genre;
import com.myapp.entity.User;
import com.myapp.service.CityService;
import com.myapp.service.UserService;
import com.myapp.validator.UserValidator;

@Controller
public class UserController {
      	final static Logger log = Logger.getLogger(UserController.class);

    @Autowired
	private UserService userService;
        
    @Autowired
	private CityService cityService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}        

	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}   

@Autowired
private UserValidator userValidator;
/*@InitBinder
private void intiBinder(WebDataBinder binder)
{ binder.setValidator(userValidator);
        }
  */
        

	@RequestMapping(value="/register", method = RequestMethod.GET)
	//public String registerUser(Map<String, Object> m ) { //@ModelAttribute User user) {
	public ModelAndView registerUser (Map<String, Object> m) {
		log.debug("********************* RegisterUser*************************");
		 User userForm = new User();    
	     m.put("userForm", userForm);
		
	     
		List<Genre> genderList = new ArrayList<Genre>( Arrays.asList(Genre.values() ));
		//genderList.add("male");
		//genderList.add("female");
		//List<City> cities = new ArrayList<City>( Arrays.asList(City.values() ));
		 
		 m.put("genderList", genderList);
			     
		List<String> cityList = cityService.getListNomCity();
		 m.put("cityList", cityList);
		 
/*		Map<String, List> map = new HashMap<String, List>();
		map.put("genderList", genderList);
		map.put("cityList", cityList);
 */
		log.debug("********************* END RegisterUser GET*************************");
		//return "register";
		
		return new ModelAndView("register", "map", m);
	}
     
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public ModelAndView submitForm (@ModelAttribute("userForm") @Valid User user, BindingResult result)
	{

		log.debug("********************* RegisterUser POST*************************");		
		/*DataBinder binder = new DataBinder(user);
		binder.setValidator(validator);
		binder.validate();
		BindingResult result = binder.getBindingResult();
		*/
		
		userValidator.validate(user, result);
		//result.hasErrors() ||
		if ( user.getFirstName().equals("")||user.getLastName().equals(""))
		{

			log.debug("**********************************************");
			log.debug(user.toString());
			log.debug("**********************************************");
			 Map<String, Object> m = new HashMap<>(); 
			 User userForm = new User();    
		     m.put("userForm", userForm);	
		     
			 
			List<String> cityList = cityService.getListNomCity();
			m.put("cityList", cityList);
			 
			List<Genre> genderList = new ArrayList<Genre>( Arrays.asList(Genre.values()));
  		    m.put("genderList", genderList);
				     
			log.debug("********************* END Validation RegisterUser POST*************************");
			return new ModelAndView("register", "map", m);
			
		}
		else
		{			
		if (user != null) {
			String nom = user.getCity().getNom();
			log.debug("** InsertUser: user.city.nom: "+ nom);
		    user.getCity().setId(cityService.getIdByNom(nom));
		    //log.debug("** InsertUser: user.city.id: "+ nom);
			userService.insertData(user);
		}		
		log.debug("********************* END SAVE RegisterUser POST*************************");
		List<User> userList = userService.getUserList();
		return new ModelAndView("userList", "userList", userList);
		}
	}

        
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public ModelAndView getUserList() {
		List<User> userList = userService.getUserList();
		return new ModelAndView("userList", "userList", userList);
	}

	
	@RequestMapping(value="/edit", method = RequestMethod.GET)
	public ModelAndView editUser(@RequestParam Integer id,
			@ModelAttribute User user) {

		user = userService.getUser(id);


		Map<String, Object> map = new HashMap<String, Object>();

		map.put("cityList", cityService.getListNomCity());
		map.put("user", user);

		return new ModelAndView("edit", "map", map);

	}

	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute User user) {
		log.debug("************************************User.gender "+user.getGender());
		user.setGender(user.getGender());
		String nom = user.getCity().getNom();
		log.debug("** UpdateUser: user.city.nom: "+ nom);
	    user.getCity().setId(cityService.getIdByNom(nom));		
		userService.updateData(user);
		return "redirect:/userList";

	}

	@RequestMapping(value="/delete") //, method = RequestMethod.POST)
	public String deleteUser(@RequestParam Integer id) {
		System.out.println("id = " + id);
		userService.deleteData(id);
		return "redirect:/userList";
	}    
        
        
        
        @RequestMapping(value="/existe")
	public @ResponseBody String existeUser(@RequestParam("firstname") String firstname)
        {
		return userService.getExistFirstname(firstname);       
        }        
    @RequestMapping(value="/userjson") 
    	public ModelAndView JsonList() {
 
		List<User> userList = userService.getUserList(); 
		
		String message = new Gson().toJson(userList); 
		Map<String, Object> map = new HashMap<String, Object>();
		return new ModelAndView("userListJson", "message", message);		
   	}    

}
