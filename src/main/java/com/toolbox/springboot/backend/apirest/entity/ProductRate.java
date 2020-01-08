package com.toolbox.springboot.backend.apirest.entity;

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
@Table(name="productRate")
public class ProductRate implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productRateId;
	
	private Long productRate;

	@ManyToOne(fetch =FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name="productId")
	private Product product;

	


	public Long getProductRateId() {
		return productRateId;
	}




	public void setProductRateId(Long productRateId) {
		this.productRateId = productRateId;
	}




	public Long getProductRate() {
		return productRate;
	}




	public void setProductRate(Long productRate) {
		this.productRate = productRate;
	}




	public Product getProduct() {
		return product;
	}




	public void setProduct(Product product) {
		this.product = product;
	}




	private static final long serialVersionUID = 1L;
}
