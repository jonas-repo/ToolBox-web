package com.toolbox.springboot.backend.apirest.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usersPayment")
public class UsersPayment implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idUsersPayment;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName="userId")
	private UserGeneral partnerUserPaymentId;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "userClientId" )
	private UserGeneral clientUserPaymentId;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName="paymentId")
	private Payment paymentId;
	
	public long getIdUsersPayment() {
		return idUsersPayment;
	}

	public UserGeneral getPartnerUserPaymentId() {
		return partnerUserPaymentId;
	}

	public void setPartnerUserPaymentId(UserGeneral partnerUserPaymentId) {
		this.partnerUserPaymentId = partnerUserPaymentId;
	}

	public UserGeneral getClientUserPaymentId() {
		return clientUserPaymentId;
	}

	public void setClientUserPaymentId(UserGeneral clientUserPaymentId) {
		this.clientUserPaymentId = clientUserPaymentId;
	}

	public Payment getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Payment paymentId) {
		this.paymentId = paymentId;
	}
	
	
	
	
	
}
