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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.toolbox.springboot.backend.apirest.model.entity.Product;
import com.toolbox.springboot.backend.apirest.model.entity.UserGeneral;

@Entity
@Table(name="userPartnerProducts")
public class UserPartnerProducts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long userPartnerProductsId;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	@JsonIgnore
	private UserGeneral userId;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "productId")
	@JsonIgnore
	private Product productId;
	
	public UserPartnerProducts() {
		
	}

	public UserPartnerProducts(long userPartnerProductsId, UserGeneral userId, Product productId) {
		super();
		this.userPartnerProductsId = userPartnerProductsId;
		this.userId = userId;
		this.productId = productId;
	}

	public long getUserPartnerProductsId() {
		return userPartnerProductsId;
	}

	public void setUserPartnerProductsId(long userPartnerProductsId) {
		this.userPartnerProductsId = userPartnerProductsId;
	}

	public UserGeneral getUserId() {
		return userId;
	}

	public void setUserId(UserGeneral userId) {
		this.userId = userId;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}
	
}
