package com.toolbox.springboot.backend.apirest.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "paypalMethod")
public class PaypalMethod implements Serializable
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long paypalId;
	
	@NotEmpty
	@Size(max = 50)
	private String paypalEmail;
	
	@NotEmpty
	@Size(max = 50)
	private String paypalPassword;

	public long getPaypalId()
	{
		return paypalId;
	}

	public String getPaypalEmail() 
	{
		return paypalEmail;
	}

	public void setPaypalEmail(String paypalEmail)
	{
		this.paypalEmail = paypalEmail;
	}

	public String getPaypalPassword() 
	{
		return paypalPassword;
	}

	public void setPaypalPassword(String paypalPassword) 
	{
		this.paypalPassword = paypalPassword;
	}
	
	
	
	
	
	
	
	
}
