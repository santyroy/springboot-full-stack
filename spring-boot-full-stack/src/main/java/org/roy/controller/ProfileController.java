package org.roy.controller;

import java.security.Principal;
import java.util.List;

import org.roy.model.Task;
import org.roy.model.User;
import org.roy.service.TaskService;
import org.roy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

	@Autowired
	private TaskService taskService;

	@Autowired
	private UserService userService;

	@GetMapping("/profile")
	public String showProfile(Model model, Principal principal) {
		String email = principal.getName();
		User user = userService.findOne(email).get();
		List<Task> tasks = taskService.findUserTasks(user);
		model.addAttribute("tasks", tasks);
		return "views/profile";
	}
}
