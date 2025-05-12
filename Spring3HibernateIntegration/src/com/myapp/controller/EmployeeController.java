package com.myapp.controller;

import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myapp.entity.Employee;
import com.myapp.service.EmployeeManager;
import com.myapp.validator.EmployeeValidator;

@Controller
public class EmployeeController {
      final static Logger log = Logger.getLogger(EmployeeController.class);
 
   
	@Autowired
	private EmployeeManager employeeManager;
	
	public void setEmployeeManager(EmployeeManager employeeManager) {
		this.employeeManager = employeeManager;
	}

	@Autowired
	private EmployeeValidator employeeValidator;	

	/*@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(employeeValidator);
	}
	*/

	
	@RequestMapping(value = "/employeeList", method = RequestMethod.GET)
	public String listEmployees(ModelMap map) {
		
		map.addAttribute("employeeList", employeeManager.getAllEmployees());

		return "employeeList";
	}

	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public String NewEmployee(Map<String, Object> map) {
		
		map.put("employeeForm", new Employee());


		return "editEmployee";
	}	
	
	@RequestMapping(value = "/editEmployee", method = RequestMethod.POST)
	//public String addEmployee(@Valid  Employee employee, BindingResult result) {
	//	employeeValidator.validate(employee, result);

	// 
	
	public String addEmployee(@Valid @ModelAttribute("employeeForm") Employee employee, 
			                  BindingResult result, Map<String, Object> model ) 
	{
		
		employeeValidator.validate(employee, result);
		//  result.hasErrors() ||
		if ( employee.getFirstname().equals("")  || employee.getLastname().equals("") )
		{
			log.debug("********************** Has errors :"+employee.toString());
			
			//return "redirect:editEmployee";
			return "editEmployee";
		}

	
		log.debug("********************** abans insert");		
		log.debug("********************** "+employee.toString());
		employeeManager.addEmployee(employee);
		log.debug("********************** despres insert");
		
		return "redirect:/employeeList";
	}

	@RequestMapping("/delete/{employeeId}")
	public String deleteEmplyee(@PathVariable("employeeId") Integer employeeId) {
		employeeManager.deleteEmployee(employeeId);
		return "redirect:/employeeList";
	}

        



}
