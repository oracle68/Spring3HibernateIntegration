package com.myapp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.myapp.entity.User;
import com.myapp.service.UserService;

@Controller
public class UserControllerAngular {

  	final static Logger log = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/userListAngular", method = RequestMethod.GET)
	public ModelAndView getUserListAngular() {
		List<User> userList = userService.getUserList();
		String lista = new Gson().toJson(userList);
		return new ModelAndView("userListAngular","lista",lista);
	}

	@RequestMapping(value = "/userListAngular2", method = RequestMethod.GET)
	public String getUserListAngular2() {
		return "userListAngular2";
	}



	@RequestMapping(value="/userJson") 
	public @ResponseBody String JsonList() {

	List<User> userList = userService.getUserList(); 
	
	String message = new Gson().toJson(userList); 
	return message;		
	}   


	@RequestMapping(value = "/userList4", method = RequestMethod.GET,
			produces="application/json",
			headers = { "Accept=application/json","Content-Type=application/json" })
	public void getUserList4(HttpServletResponse response) throws IOException {
		List<User> us = userService.getUserList();
	    response.setHeader("Custom-Header", "userList");
	    response.setStatus(200);
	    response.getWriter().println(us);
	    response.getWriter().println(us.size());	
	
	}
	


}
