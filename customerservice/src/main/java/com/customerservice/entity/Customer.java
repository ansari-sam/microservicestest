package com.customerservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cusId;
	private String cusName;
	private String email;
	private String password;
	private String address;
	@JsonIgnore
	private int[] productId;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Customer(int cusId, String cusName, String email, String password, String address, int[] productId) {
		super();
		this.cusId = cusId;
		this.cusName = cusName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.productId = productId;
	}


	public Customer(int cusId, String cusName, String email, String password, String address) {
		super();
		this.cusId = cusId;
		this.cusName = cusName;
		this.email = email;
		this.password = password;
		this.address = address;
	}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int[] getProductId() {
		return productId;
	}

	public void setProductId(int[] productId) {
		this.productId = productId;
	}

}
