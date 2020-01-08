package com.toolbox.springboot.backend.apirest.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "rentPayment")
public class RentPayment implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long rentPaymentId;
	
	@NotEmpty
	@Temporal(TemporalType.DATE)
	private Date rentPaymentTimeStart;
	
	@NotEmpty
	@Temporal(TemporalType.DATE)
	private Date rentPaymentTimeEnd;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "paymentId" )
	private Payment paymentId;
	
	@Temporal(TemporalType.DATE)
	private Date rentPaymentDate;

	public long getRentPaymentId() {
		return rentPaymentId;
	}

	public Date getRentPaymentTimeStart() {
		return rentPaymentTimeStart;
	}

	public void setRentPaymentTimeStart(Date rentPaymentTimeStart) {
		this.rentPaymentTimeStart = rentPaymentTimeStart;
	}

	public Date getRentPaymentTimeEnd() {
		return rentPaymentTimeEnd;
	}

	public void setRentPaymentTimeEnd(Date rentPaymentTimeEnd) {
		this.rentPaymentTimeEnd = rentPaymentTimeEnd;
	}

	public Payment getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Payment paymentId) {
		this.paymentId = paymentId;
	}

	public Date getRentPaymentDate() {
		return rentPaymentDate;
	}

	public void setRentPaymentDate(Date rentPaymentDate) {
		this.rentPaymentDate = rentPaymentDate;
	}
	
	
	
	
	
}
