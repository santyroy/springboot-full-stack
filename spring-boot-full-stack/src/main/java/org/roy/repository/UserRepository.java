package org.roy.repository;

import java.util.List;

import org.roy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{

	List<User> findByNameLike(String name);

}
