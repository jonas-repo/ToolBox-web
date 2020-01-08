package com.toolbox.springboot.backend.apirest.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="cardMethod")
public class CardMethod implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long cardId;
	
	@NotNull
	@NotEmpty
	private String cardNumber;
	
	@NotNull
	@NotEmpty
	private int cardCvvNumber;
	
	@NotNull
	@NotEmpty
	private String cardName;
	
	@NotNull
	@NotEmpty
	private String cardClientName;
	
	@NotNull
	@NotEmpty
	private Date cardValidateDate;
	
	public CardMethod() {
		
	}

	public CardMethod(long cardId, @NotNull @NotEmpty String cardNumber, @NotNull @NotEmpty int cardCvvNumber,
			@NotNull @NotEmpty String cardName, @NotNull @NotEmpty String cardClientName,
			@NotNull @NotEmpty Date cardValidateDate) {
		super();
		this.cardId = cardId;
		this.cardNumber = cardNumber;
		this.cardCvvNumber = cardCvvNumber;
		this.cardName = cardName;
		this.cardClientName = cardClientName;
		this.cardValidateDate = cardValidateDate;
	}

	public long getCardId() {
		return cardId;
	}

	public void setCardId(long cardId) {
		this.cardId = cardId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCardCvvNumber() {
		return cardCvvNumber;
	}

	public void setCardCvvNumber(int cardCvvNumber) {
		this.cardCvvNumber = cardCvvNumber;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardClientName() {
		return cardClientName;
	}

	public void setCardClientName(String cardClientName) {
		this.cardClientName = cardClientName;
	}

	public Date getCardValidateDate() {
		return cardValidateDate;
	}

	public void setCardValidateDate(Date cardValidateDate) {
		this.cardValidateDate = cardValidateDate;
	}
	
	
}
