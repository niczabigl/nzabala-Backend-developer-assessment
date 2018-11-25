package com.nzabala.dtos;

import java.util.ArrayList;

import com.nzabala.models.Policy;

public class UserPolicies {
	private String userId;
	private String userName;
	private ArrayList<Policy> userPolicies;
	
	public UserPolicies(){
		this.userPolicies = new ArrayList<Policy>();
	}
	public UserPolicies(String userId, String userName, ArrayList<Policy> userPolicies){
		this.userId = userId;
		this.userName = userName;
		this.userPolicies = userPolicies;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public ArrayList<Policy> getUserPolicies() {
		return userPolicies;
	}
	public void setUserPolicies(ArrayList<Policy> userPolicies) {
		this.userPolicies = userPolicies;
	}
	
	public void addPolicy(Policy policy){
		this.userPolicies.add(policy);
	}
}
