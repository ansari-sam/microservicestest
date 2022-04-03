package com.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerservice.entity.Customer;
import com.customerservice.entity.Myorders;
import com.customerservice.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@PostMapping("/")
	public ResponseEntity<Object> saveCustomer(@RequestBody Customer customer){
		Customer cust=null;
		
		if(customer!=null) {
			cust = this.customerService.saveCustomer(customer);
			return new ResponseEntity<Object>(cust, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Customer details should not be empty!!", HttpStatus.BAD_REQUEST);
	}
	@GetMapping("/{custId}")
	public ResponseEntity<Object> getCustomer(@PathVariable("custId") int id){
		Customer cust=null;
		cust = this.customerService.getCustomer(id);
		if(cust!=null) {
			return new ResponseEntity<Object>(cust, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Customer Id should not be blank or customer not found", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/")
	public ResponseEntity<Object> getCustomers(){
		List<Customer> customers=null;
		customers = this.customerService.getCustomers();
		if(customers!=null) {
			return new ResponseEntity<Object>(customers, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Customers not found", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{custId}/myorders")
	public ResponseEntity<Object> getMyOrders(@PathVariable("custId") int id){
		Myorders orders=null;
		orders = this.customerService.getMyOrders(id);
		if(orders!=null) {
			return new ResponseEntity<Object>(orders, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Customers not found", HttpStatus.NOT_FOUND);
	}
}
