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

@Entity
@Table(name="productPayment")
public class ProductPayment implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long productPaymentId;
	
	@ManyToOne(fetch =FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name="productId")
	private Product product;
	
	////////////////////
	// Falta PaymentID
	
	
	
	private static final long serialVersionUID = 1L;

	public Long getProductPaymentId() {
		return productPaymentId;
	}

	public void setProductPaymentId(Long productPaymentId) {
		this.productPaymentId = productPaymentId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
