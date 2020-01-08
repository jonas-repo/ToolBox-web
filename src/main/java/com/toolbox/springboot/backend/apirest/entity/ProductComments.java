package com.toolbox.springboot.backend.apirest.entity;

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
@Table(name="productComments")
public class ProductComments implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productCommentId;
	
	private String productComment;
	
	@Temporal(TemporalType.DATE)
	private Date productCommentDate;
	
	@ManyToOne(fetch =FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name="productId")
	private Product product;
	

	
	

	public Long getProductCommentId() {
		return productCommentId;
	}





	public void setProductCommentId(Long productCommentId) {
		this.productCommentId = productCommentId;
	}





	public String getProductComment() {
		return productComment;
	}





	public void setProductComment(String productComment) {
		this.productComment = productComment;
	}





	public Date getProductCommentDate() {
		return productCommentDate;
	}





	public void setProductCommentDate(Date productCommentDate) {
		this.productCommentDate = productCommentDate;
	}





	public Product getProduct() {
		return product;
	}





	public void setProduct(Product product) {
		this.product = product;
	}





	private static final long serialVersionUID = 1L;

}
