package com.nzabala.models;

import java.util.Date;

public class Policy {
	
	private String id;
	private Integer amountInsured;
	private String email;
	private Date inceptionDate;
	private Boolean installmentPayment;
	private String clientId;
	
	public Policy(){
		
	}
	
	public Policy (String id,Integer amountInsured,String email,Date inceptionDate,Boolean installmentPayment,String clientId){
		this.id = id;
		this.amountInsured = amountInsured;
		this.email = email;
		this.inceptionDate = inceptionDate;
		this.installmentPayment = installmentPayment;
		this.clientId = clientId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAmountInsured() {
		return amountInsured;
	}

	public void setAmountInsured(Integer amountInsured) {
		this.amountInsured = amountInsured;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getInceptionDate() {
		return inceptionDate;
	}

	public void setInceptionDate(Date inceptionDate) {
		this.inceptionDate = inceptionDate;
	}

	public Boolean getInstallmentPayment() {
		return installmentPayment;
	}

	public void setInstallmentPayment(Boolean installmentPayment) {
		this.installmentPayment = installmentPayment;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	
}
