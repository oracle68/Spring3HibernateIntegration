package com.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.entity.User;
import com.myapp.service.UserService;

@RestController
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/userJson2", method = RequestMethod.GET
	 ,produces="application/json"
	,headers = { "Accept=application/json","Content-Type=application/json" }) 
	public  List<User> JsonList2() {
	
		return userService.getUserList();		
	} 
}
