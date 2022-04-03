package com.customerservice.entity;

public class Product {
	private long prodId;
	private String prodName;
	private String prodPrice;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(long prodId, String prodName, String prodPrice) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
	}
	public long getProdId() {
		return prodId;
	}
	public void setProdId(long prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(String prodPrice) {
		this.prodPrice = prodPrice;
	}
	
	
}
