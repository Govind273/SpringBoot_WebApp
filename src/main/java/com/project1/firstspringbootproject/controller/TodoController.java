package com.project1.firstspringbootproject.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project1.firstspringbootproject.model.Todo;
import com.project1.firstspringbootproject.service.TodoService;


@Controller
@SessionAttributes("name")
public class TodoController {
	 
	@Autowired
	TodoService service;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@RequestMapping(value="/list-todos", method= RequestMethod.GET)
	public String showTodods(ModelMap model) {
		String name = (String)model.get("name");
		model.put("todo1", service.retrieveTodos(name));
		return "list-todos";
	}	
	
	@RequestMapping(value="/add-todo", method= RequestMethod.GET)
	public String showTodod(ModelMap model) {
		model.addAttribute("todo",new Todo(0, (String)model.get("name"),"",new Date(),false));
		return "todo";
	}	
	
	@RequestMapping(value="/delete-todo", method= RequestMethod.GET)
	public String deletTodo(@RequestParam int id) {
		service.deleteTodo(id);
		return "redirect:/list-todos";
	}	
	
	@RequestMapping(value="/update-todo", method= RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id,ModelMap model) {
		Todo todo = service.retrieveTodo(id);  
		model.put("todo", todo);
		return "todo"; 
	} 
	
	@RequestMapping(value="/update-todo", method= RequestMethod.POST)
	public String updateTodo(@Valid Todo todo, BindingResult result,ModelMap model) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		todo.setUser((String)model.get("name"));
		service.updateTodo(todo);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/add-todo", method= RequestMethod.POST)
	public String addTodod(ModelMap model,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		 service.addTodo((String)model.get("name"), todo.getDesc(), todo.getTargetDate(),false);
		return "redirect:/list-todos";
	}
	
	
}
  