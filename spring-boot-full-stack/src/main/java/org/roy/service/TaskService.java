package org.roy.service;

import java.util.List;

import org.roy.model.Task;
import org.roy.model.User;
import org.roy.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	public void addTask(Task task, User user) {
		task.setUser(user);
		taskRepository.save(task);
	}
	
	public List<Task> findUserTasks(User user) {
		return taskRepository.findByUser(user);
	}
}
