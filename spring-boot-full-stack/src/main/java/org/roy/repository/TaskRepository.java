package org.roy.repository;

import java.util.List;

import org.roy.model.Task;
import org.roy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findByUser(User user);

}
