package com.customerservice.service;

import java.util.List;

import com.customerservice.entity.Customer;
import com.customerservice.entity.Myorders;

public interface CustomerService {

	public Customer saveCustomer(Customer customer);
	
	public Customer getCustomer(int custId);
	
	public List<Customer> getCustomers();

	public Myorders getMyOrders(int custId);
}
