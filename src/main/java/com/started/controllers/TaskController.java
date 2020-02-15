package com.started.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.started.model.Task;
import com.started.services.TaskServiceImpl;

@Controller
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	private TaskServiceImpl taskService;
	
	
	public List<Task> list() {
		return taskService.list();
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping
	public String showForm(Task task) {
		return "tasks/form";
	}
	
	@Secured("ROLE_ADMIN")
	@PostMapping
	public String  save(@Valid Task task, BindingResult bindingResult, RedirectAttributes ra) {
		String message = "Task saved.";
		try {
			if (bindingResult.hasErrors()) 
				return "/tasks/form";
			taskService.save(task);
			
		} catch (Exception e) {
			message = "Error.";
		} 
		ra.addFlashAttribute("message", message);
		return "redirect:/tasks";
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/find/{id}")
	public ModelAndView findByTitle (@PathVariable(required = true, name = "id") int id) {
		ModelAndView mav = new ModelAndView("tasks/form");
		Task task = taskService.findById(id);
		mav.addObject("task", task);
		return mav;
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/remove/{id}")
	public String remove(RedirectAttributes ra, @PathVariable(required = true, name = "id") int id) {
		String message = "Tasl deleted";
		try {
			taskService.delete(taskService.findById(id));
		} catch (Exception e) {
			message = "Error";
		}
		finally {
			ra.addFlashAttribute("message", message);
		}
		return "redirect:/tasks/list";
	}
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/list")
	public void getTasks(Model model) {
		model.addAttribute("tasks", this.list());
	}
	
	
	
}
