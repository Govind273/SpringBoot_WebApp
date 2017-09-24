package com.project1.firstspringbootproject.service;

import org.springframework.stereotype.Component;
@Component
public class LoginService {
	
	public boolean validateUser(String name, String password) {
		
		return name.equalsIgnoreCase("in28Minutes") && password.equalsIgnoreCase("dummy");
	}
}
