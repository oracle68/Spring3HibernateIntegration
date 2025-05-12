package com.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.myapp.entity.Employee;
import com.myapp.service.EmployeeManager;

@Controller
public class EmployeeControllerAngular {

	@Autowired
	private EmployeeManager employeeManager;

	@RequestMapping(value = "/employeeListAngular", method = RequestMethod.GET)
	public ModelAndView getUserListAngular() {
		List<Employee> employeesList = employeeManager.getAllEmployees();
		String lista = new Gson().toJson(employeesList);
		return new ModelAndView("employeeListAngular","lista",lista);
	}	
	
	@RequestMapping("/deleteEmployee/{employeeId}")
	public String deleteEmplyee(@PathVariable("employeeId") Integer employeeId) {
		employeeManager.deleteEmployee(employeeId);
		return "redirect:/employeeListAngular";
	}	
	
    @RequestMapping(value = "/adddEmployee/{firstname}/{lastname}/{email}/{telephone}", method = RequestMethod.POST)
    public String addEmpl
        (@PathVariable("firstname") String firstname,
         @PathVariable("lastname") String lastname,
         @PathVariable("email") String email,
         @PathVariable("telephone") String telephone
         ) 
    { 
        System.out.println("firstname:"+firstname);

        if (firstname!=null) {
        	Employee emp = new Employee();
        	emp.setFirstname(firstname);
        	emp.setLastname(lastname);
        	emp.setEmail(email);
        	emp.setTelephone(telephone);
        	employeeManager.addEmployee(emp);
        }	
        return "redirect:/employeeListAngular";
    }	
	
}
