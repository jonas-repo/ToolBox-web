package com.toolbox.springboot.backend.apirest.model.entity;

import java.io.Serializable;
import java.util.List;

public class ProductResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Product products;
	private List<ProductRate> ProductRate;
	private List<ProductComments> ProductComments;
	private List<ProductImage> ProductImage;
	
	public Product getProducts() {
		return products;
	}
	public void setProducts(Product products) {
		this.products = products;
	}
	public List<ProductRate> getProductRate() {
		return ProductRate;
	}
	public void setProductRate(List<ProductRate> productRate) {
		ProductRate = productRate;
	}
	public List<ProductComments> getProductComments() {
		return ProductComments;
	}
	public void setProductComments(List<ProductComments> productComments) {
		ProductComments = productComments;
	}
	public List<ProductImage> getProductImage() {
		return ProductImage;
	}
	public void setProductImage(List<ProductImage> productImage) {
		ProductImage = productImage;
	}
	
	

}
