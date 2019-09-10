package com.nzabala.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="POLICY")
@EntityListeners(AuditingEntityListener.class)
public class Policy {
	
	@Id
	@Column(name="polid")
	private String id;
	
	@Column(name="polamountinsured")
	private Float amountinsured;
	
	@Column(name="polemail")
	private String email;
	
	@Column(name="polinceptiondate")
	private Date inceptiondate;
	
	@Column(name="polinstallmentpayment")
	private Boolean installmentpayment;
	
	@OneToOne
    @JoinColumn(name = "polcliid")
	private Client client;
	
	public Policy(){
		
	}

	public Policy(String id, Float amountinsured, String email, Date inceptiondate, Boolean installmentpayment) {
		super();
		this.id = id;
		this.amountinsured = amountinsured;
		this.email = email;
		this.inceptiondate = inceptiondate;
		this.installmentpayment = installmentpayment;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Float getAmountinsured() {
		return amountinsured;
	}

	public void setAmountinsured(Float amountinsured) {
		this.amountinsured = amountinsured;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getInceptiondate() {
		return inceptiondate;
	}

	public void setInceptiondate(Date inceptiondate) {
		this.inceptiondate = inceptiondate;
	}

	public Boolean getInstallmentpayment() {
		return installmentpayment;
	}

	public void setInstallmentpayment(Boolean installmentpayment) {
		this.installmentpayment = installmentpayment;
	}


	@Override
	public String toString() {
		return "Policy [id=" + id + ", amountinsured=" + amountinsured + ", email=" + email + ", inceptiondate="
				+ inceptiondate + ", installmentpayment=" + installmentpayment + "]";
	}

	public void setClient(Client client) {
		this.client = client;		
	}
	
	public Client getClient() {
		return this.client;		
	}
	
	
	
	
}
