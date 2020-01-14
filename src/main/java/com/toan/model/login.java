package com.toan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class login {
	
	@Id
	@Column(name="username")
	String username;
	
	@Column(name="password")
	String password;

	public String getUsername() {
		return username;
	}

	public login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public login() {
		super();
	}
	

}
