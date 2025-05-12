package com.myapp.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.entity.Message;
import com.myapp.entity.Persona; 

	
	
    @RestController
	public class RestService { 

    	@RequestMapping(value = "/personas", method = RequestMethod.GET)
    	public List<Persona> listaPersonas() {
    	List<Persona> lista = new ArrayList<Persona>();
    	Persona p = new Persona();
    	p.setNombre("angel");
    	p.setEdad(20);
    	lista.add(p);
    	Persona p1 = new Persona();
    	p1.setNombre("gema");
    	p1.setEdad(30);
    	lista.add(p1);
    	return lista;
    	}    	
    	@RequestMapping(value="/hello2", produces = MediaType.TEXT_PLAIN_VALUE)
    	    public String sayHello() {

    	        return "Hello there!";
    	    }    	

	/*	@RequestMapping("{param}") 
	    public Response getMsg(@PathVariable String msg) { 
	        //Mostrará por pantalla el parámetro que le hemos pasado a la URL
	        String output = "My Jersey application says : " + msg; 
	        return Response.status(200).entity(output).build(); 
	    } 
	*/	
		 @RequestMapping(value="/message/{player}", method = RequestMethod.GET)
    	//@GetMapping(value="/rest/hallo/{player}", produces = MediaType.TEXT_PLAIN_VALUE)
		    public Message message(@PathVariable("player") String player) {//REST Endpoint.
		 
		        Message msg = new Message(player, "Hello " + player);
		        return msg;
		    }		
	 
    	//@GetMapping(value="/rest/hallo1/", produces = MediaType.TEXT_PLAIN_VALUE)
		    @RequestMapping(value="/message1/", method = RequestMethod.GET)
		    public Message message() {//REST Endpoint.
		 
		        Message msg = new Message("Jonh", "Hello " + "Jonh");
		        return msg;
		    }	
		    @RequestMapping(value="/message2/", method = RequestMethod.GET)
		    public String  message2() {//REST Endpoint.
		 
		        Message msg = new Message("Jonh", "Hello " + "Jonh");
		        return "jsonTemplate";
		    }	
		 
}
