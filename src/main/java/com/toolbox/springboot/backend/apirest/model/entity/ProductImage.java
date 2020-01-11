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
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "productImage")
public class ProductImage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idImages;
	
	@NotEmpty
	private String imageRoute;
	
	@JsonIgnoreProperties({"productImage", "hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="productId")
	private Product product;
	
	public Long getIdImages() {
		return this.idImages;
	}
	
	public void setImageRoute(String imageRoute) {
		this.imageRoute = imageRoute;
	}
	public String getImageRoute() {
		return this.imageRoute;
	}
	
	public void setProductId(Product product) {
		this.product = product;
	}
	public Product getProductId() {
		return this.product;
	}

}
