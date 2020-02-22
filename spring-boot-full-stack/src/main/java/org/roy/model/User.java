package org.roy.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Id
	@Email
	@NotEmpty
	@Column(unique = true)
	private String email;

	@NotEmpty
	private String name;

	@Size(min = 4)
	private String password;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	List<Task> tasks;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLE", 
	joinColumns = {@JoinColumn(name = "USER_EMAIL", referencedColumnName = "email")},
	inverseJoinColumns = {@JoinColumn(name = "ROLE_NAME", referencedColumnName = "role_name")})
	List<Role> roles;

	public User() {

	}

	public User(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public User(String email, String name, String password, List<Task> tasks) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.tasks = tasks;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
