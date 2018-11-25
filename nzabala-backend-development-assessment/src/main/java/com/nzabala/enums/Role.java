package com.nzabala.enums;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum Role {
	
	@JsonProperty("admin")
	ADMIN,
	@JsonProperty("user")
	USER;
	
	private String role;
	Role(){
		
	}
	Role(String role){
		this.role = role;
	}
	
	public String role() {
        return role;
    }
}
