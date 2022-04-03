package com.customerservice.entity;

import java.util.List;

public class Myorders {
	
	private Customer customer;
	private List<Product> products;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
