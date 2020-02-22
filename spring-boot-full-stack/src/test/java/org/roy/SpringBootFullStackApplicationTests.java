package org.roy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.roy.model.Task;
import org.roy.model.User;
import org.roy.service.TaskService;
import org.roy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootFullStackApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private TaskService taskService;

	@BeforeEach
	public void intiDB() {
		User newUser = new User("testUser@mail.com", "testUser", "123456");
		userService.createUser(newUser);

		newUser = new User("testAdmin@mail.com", "testAdmin", "123456");
		userService.createAdmin(newUser);

		Task userTask = new Task("17/02/2020", "19:58", "20:58", "You need to work today");
		User user = userService.findOne("testUser@mail.com").get();
		taskService.addTask(userTask, user);
	}

	@Test
	public void testUser() {
		User user = userService.findOne("testUser@mail.com").get();
		assertNotNull(user);
		User admin = userService.findOne("testAdmin@mail.com").get();
		assertNotNull(admin);

		assertEquals("testUser@mail.com", user.getEmail());
		assertEquals("testAdmin@mail.com", admin.getEmail());
	}
	
	@Test
	public void testTask() {
		User user = userService.findOne("testUser@mail.com").get();
		List<Task> tasks = taskService.findUserTasks(user);
		assertNotNull(tasks);
	}

}
