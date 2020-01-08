package com.toolbox.springboot.backend.apirest.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="payment")
public class Payment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long paymentId;
	
	@NotEmpty
	@Column(nullable=false)
	private double paymentPrice;
	
	@NotEmpty
	@Column(nullable=false)
	private int paymentProductQuantity;
	
	@NotEmpty
	@Column(nullable=false)
	private String paymentPickup;
	
	@NotEmpty
	@Column(nullable=false)
	private String paymentStatus;
	
	@NotEmpty
	@Column(nullable=false)
	private Date paymentDate;

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public double getPaymentPrice() {
		return paymentPrice;
	}

	public void setPaymentPrice(double paymentPrice) {
		this.paymentPrice = paymentPrice;
	}

	public int getPaymentProductQuantity() {
		return paymentProductQuantity;
	}

	public void setPaymentProductQuantity(int paymentProductQuantity) {
		this.paymentProductQuantity = paymentProductQuantity;
	}

	public String getPaymentPickup() {
		return paymentPickup;
	}

	public void setPaymentPickup(String paymentPickup) {
		this.paymentPickup = paymentPickup;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	
}
