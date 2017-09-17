package com.project1.firstspringbootproject.service;

import org.springframework.stereotype.Component;
@Component
public class LoginService {
	
	public boolean validateUser(String name, String password) {
		
		return name.equalsIgnoreCase("a") && password.equalsIgnoreCase("b");
	}
}
