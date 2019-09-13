package com.nzabala.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="CLIENT")
@EntityListeners(AuditingEntityListener.class)
public class Client implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cliid")
	private String id;
	
	@Column(name="cliname")
	private String name;
	
	@Column(name="cliemail")
	private String email;
	
	@Column(name="clirole")
	private String role;
	
//	@OneToOne(mappedBy = "client")
//    private Policy policy;
	
	public Client(){
		
	}
	
	public Client(String id, String name, String email, String role){
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", email=" + email + ", role=" + role + "]";
	}
	
	
}
