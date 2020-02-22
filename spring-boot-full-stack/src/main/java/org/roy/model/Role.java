package org.roy.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role {

	@Id
	private String role_name;
	
	@ManyToMany(mappedBy = "roles")
	private List<User> users;

	public Role() {

	}

	public Role(String role_name) {
		this.role_name = role_name;
	}

	public Role(String role_name, List<User> users) {
		this.role_name = role_name;
		this.users = users;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
