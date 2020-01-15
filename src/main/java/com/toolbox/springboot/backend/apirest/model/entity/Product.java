package com.toolbox.springboot.backend.apirest.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="product")
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long productId;
	
	@NotEmpty
	@Size(max = 50)
	private String productDescription;
	
	@Size(max = 50)
	@Column(nullable = true)
	private String productBrand;
	
	@Column(precision = 2)
	private double productPrice;
	
	@Size(max = 50)
	@Column(nullable = true)
	private String productModel;
	
	@NotEmpty
	@Size(max = 50)
	private String productName;
	
	@Column(nullable = true)
	private int productQuantity;
	
	@Temporal(TemporalType.DATE)
	private Date productDate;
	
	@OneToMany(mappedBy="product")
	@JsonIgnore
	List<ProductRate> productRate;
	
	@JsonIgnore
	@OneToMany(mappedBy="product")
	List<ProductComments> productComments;
	
	@JsonIgnoreProperties({"productId", "hibernateLazyInitializer", "handler"})
	@OneToMany(fetch=FetchType.LAZY, mappedBy="product", cascade=CascadeType.ALL)
	List<ProductImage> productImage;
	
	@OneToMany(mappedBy="productId")
	@JsonIgnore
	public List<UserPartnerProducts> userPartnerProducts;

	@JsonIgnore
	@OneToMany(mappedBy="product")
	List<ProductPayment> productPayment;
	
	@JsonIgnoreProperties({"product", "hibernateLazyInitializer", "handler"})
	@OneToMany(fetch=FetchType.LAZY, mappedBy="product", cascade=CascadeType.ALL)
	List<ProductCategory> productCategory;
	


	
	

	public List<ProductCategory> getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(List<ProductCategory> productCategory) {
		this.productCategory = productCategory;
	}

	public Product() {
		this.productImage = new ArrayList<>();
	}
	
	@PrePersist
	public void prePersist() {
		this.productDate = new Date();
	}
	
	public List<ProductRate> getProductRate() {
		return productRate;
	}

	public void setProductRate(List<ProductRate> productRate) {
		this.productRate = productRate;
	}

	public List<ProductComments> getProductComments() {
		return productComments;
	}

	public void setProductComments(List<ProductComments> productComments) {
		this.productComments = productComments;
	}

	public List<ProductImage> getProductImage() {
		return productImage;
	}

	public void setProductImage(List<ProductImage> productImage) {
		this.productImage = productImage;
	}

	public Long getProductId() {
		return this.productId;
	}
	
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductDescription() {
		return this.productDescription;
	}
	
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public String getProductBrand() {
		return this.productBrand;
	}
	
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public double getProductPrice() {
		return this.productPrice;
	}
	
	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}
	public String getProductModel() {
		return this.productModel;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductName() {
		return this.productName;
	}
	
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public int getProductQuantity() {
		return this.productQuantity;
	}
	
	public void setProductDate(Date date) {
		this.productDate = date;
	}
	public Date getProductDate() {
		return this.productDate;
	}

	public List<ProductPayment> getProductPayment() {
		return productPayment;
	}

	public void setProductPayment(List<ProductPayment> productPayment) {
		this.productPayment = productPayment;
	}
	
	
}
