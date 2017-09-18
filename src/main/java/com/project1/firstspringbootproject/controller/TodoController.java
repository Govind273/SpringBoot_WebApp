package com.project1.firstspringbootproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.project1.firstspringbootproject.service.LoginService;
import com.project1.firstspringbootproject.service.TodoService;


@Controller
public class TodoController {
	
	@Autowired
	TodoService service;
	
	@RequestMapping(value="/list-todos", method= RequestMethod.GET)
	public String showTodods(ModelMap model) {
		model.put("todo1", service.retrieveTodos("in28Minutes"));
		return "list-todos";
	}	
	
}
  