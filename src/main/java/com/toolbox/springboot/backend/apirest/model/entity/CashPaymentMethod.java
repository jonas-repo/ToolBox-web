package com.toolbox.springboot.backend.apirest.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cashPaymentMethod")
public class CashPaymentMethod implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cashPaymentId;
	
	private boolean cashPaymentInUse;
	
	

	public Long getCashPaymentId() {
		return cashPaymentId;
	}

	public void setCashPaymentId(Long cashPaymentId) {
		this.cashPaymentId = cashPaymentId;
	}

	public boolean isCashPaymentInUse() {
		return cashPaymentInUse;
	}

	public void setCashPaymentInUse(boolean cashPaymentInUse) {
		this.cashPaymentInUse = cashPaymentInUse;
	}

	private static final long serialVersionUID = 1L;

}
