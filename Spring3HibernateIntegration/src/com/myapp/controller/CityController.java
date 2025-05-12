/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myapp.entity.City;
import com.myapp.service.CityService;

@Controller
public class CityController {
      	//final static Logger log = Logger.getLogger(MainController.class);
        @Autowired
	private CityService cityService;
 

  	
	@RequestMapping(value = "/listcity", method = RequestMethod.GET)
	public ModelAndView getCityList() {
		List<City> cityList = cityService.getCityList();
	
		return new ModelAndView("listcity", "cityList", cityList);
	}

	
        //, method = RequestMethod.POST) //, produces = MediaType.APPLICATION_JSON_VALUE)
	//public ModelAndView addCity(@RequestBody City city,BindingResult result) {
          @RequestMapping(value="/addcity")
          public @ResponseBody String addCity(@RequestParam("nom") String nom) { //(@RequestBody City city) {      
            String mensaje ="OK";
            System.out.println(" nom="+nom);
             try{   
             if (nom!=null)
             {
                City city =new City();    
                city.setNom(nom);
                cityService.insertData(city);
             }
             else mensaje="Nom is null";
             } catch (Exception e) { 
                                     mensaje="Error"; 
                                     System.out.println(e);
                                    }   
             //return new ModelAndView("addcity", "mensaje", mensaje);
             System.out.println("mensaje="+mensaje);
             return mensaje;
	}
          


}

