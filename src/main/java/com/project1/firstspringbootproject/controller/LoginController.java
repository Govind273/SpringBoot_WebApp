package com.project1.firstspringbootproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project1.firstspringbootproject.service.LoginService;


@Controller
public class LoginController {
	
	//LoginService service;
	
	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String showLogin(ModelMap model) {
		//model.put("e" , name); 
		return "login";
	}	
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public String showWelcome(ModelMap model, @RequestParam String name, @RequestParam String password) {
		model.put("name" , name); 
		model.put("pass" , password);
		return "welcome";
	}	
}
  