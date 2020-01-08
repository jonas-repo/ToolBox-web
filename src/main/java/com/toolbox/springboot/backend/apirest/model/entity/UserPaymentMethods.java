package com.toolbox.springboot.backend.apirest.model.entity;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="userPaymentMethods")
public class UserPaymentMethods implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long paymentMethodId;
	
	@ManyToOne(fetch =FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name="userId")
	private UserGeneral userGeneral;
	
	private int paymentMethodIdForeign;
	
	private String paymentMethodName;
	
	@Temporal(TemporalType.DATE)
	private Date userPaymentDate;
	
	
	
	public Long getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(Long paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public UserGeneral getUserGeneral() {
		return userGeneral;
	}

	public void setUserGeneral(UserGeneral userGeneral) {
		this.userGeneral = userGeneral;
	}

	public int getPaymentMethodIdForeign() {
		return paymentMethodIdForeign;
	}

	public void setPaymentMethodIdForeign(int paymentMethodIdForeign) {
		this.paymentMethodIdForeign = paymentMethodIdForeign;
	}

	public String getPaymentMethodName() {
		return paymentMethodName;
	}

	public void setPaymentMethodName(String paymentMethodName) {
		this.paymentMethodName = paymentMethodName;
	}

	public Date getUserPaymentDate() {
		return userPaymentDate;
	}

	public void setUserPaymentDate(Date userPaymentDate) {
		this.userPaymentDate = userPaymentDate;
	}

	private static final long serialVersionUID = 1L;

}
