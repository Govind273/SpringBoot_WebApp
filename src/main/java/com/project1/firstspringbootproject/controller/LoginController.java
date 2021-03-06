package com.project1.firstspringbootproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project1.firstspringbootproject.service.LoginService;


@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	LoginService service;
	 
	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String showLogin(ModelMap model) {
		
		return "login";
	}	
	
	
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public String showWelcome(ModelMap model, @RequestParam String name, @RequestParam String password) {
		boolean isValidUser = service.validateUser(name, password);
		
		if(!isValidUser) {
			model.put("message", "Please correct the email and Password");
			return "login";
		}
		model.put("name" , name); 
		model.put("pass" , password);
		return "welcome";
	}	
}
  