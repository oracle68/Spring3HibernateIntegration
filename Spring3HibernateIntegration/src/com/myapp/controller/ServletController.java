package com.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ServletController {

 	@RequestMapping(value = "/sj", method = RequestMethod.GET)
    public String svJson()
    {
        return "ServletJSON";
    }  

}
