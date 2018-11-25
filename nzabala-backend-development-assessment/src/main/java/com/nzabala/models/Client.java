package com.nzabala.models;

import com.nzabala.enums.Role;

public class Client {
	
	private String id;
	private String name;
	private String email;
	private Role role;
	
	public Client(){
		
	}
	
	public Client(String id, String name, String email, Role role){
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
