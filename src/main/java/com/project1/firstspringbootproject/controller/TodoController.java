package com.project1.firstspringbootproject.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project1.firstspringbootproject.service.LoginService;
import com.project1.firstspringbootproject.service.TodoService;


@Controller
@SessionAttributes("name")
public class TodoController {
	 
	@Autowired
	TodoService service;
	
	@RequestMapping(value="/list-todos", method= RequestMethod.GET)
	public String showTodods(ModelMap model) {
		String name = (String)model.get("name");
		model.put("todo1", service.retrieveTodos(name));
		return "list-todos";
	}	
	
	@RequestMapping(value="/add-todo", method= RequestMethod.GET)
	public String showTodod(ModelMap model) {
		return "todo";
	}	
	
	@RequestMapping(value="/add-todo", method= RequestMethod.POST)
	public String addTodod(ModelMap model,@RequestParam String desc) {
		 service.addTodo((String)model.get("name"), desc, new Date() , false);
		return "redirect:/list-todos";
	}	
	
}
  