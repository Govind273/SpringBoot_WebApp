package com.project1.firstspringbootproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {
	@RequestMapping("/login")
	public String loginMessage(ModelMap model) {
		//model.put("e" , name); 
		return "login";
	}	
}
  