package org.roy.controller;

import javax.validation.Valid;

import org.roy.model.User;
import org.roy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/register")
	public String registerForm(Model model) {
		
		model.addAttribute("user", new User());
		return "views/register-form";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid User user, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "views/register-form";
		}
		if(userService.isUserPresent(user.getEmail())) {
			model.addAttribute("exists", true);
			return "views/register-form";
		}
		
		userService.createUser(user);
		return "views/register-success";
	}
}
