package com.toolbox.springboot.backend.apirest.model.entity;

import java.util.List;

public class ShoppingInfo {
	
	private List<Product> cartItems;
	private List<Integer> cartPrices;
	private double totals;
	private String userIdentifier;
	
	
	public String getUserIdentifier() {
		return userIdentifier;
	}
	public void setUserIdentifier(String userIdentifier) {
		this.userIdentifier = userIdentifier;
	}
	public List<Product> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<Product> cartItems) {
		this.cartItems = cartItems;
	}
	public List<Integer> getCartPrices() {
		return cartPrices;
	}
	public void setCartPrices(List<Integer> cartPrices) {
		this.cartPrices = cartPrices;
	}
	public double getTotals() {
		return totals;
	}
	public void setTotals(double totals) {
		this.totals = totals;
	}
	
	

}
