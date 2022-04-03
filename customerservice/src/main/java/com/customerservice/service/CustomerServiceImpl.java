package com.customerservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.customerservice.dao.CustomerRepo;
import com.customerservice.entity.Customer;
import com.customerservice.entity.Myorders;
import com.customerservice.entity.Product;

@Service
@RefreshScope
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	@Lazy
	private RestTemplate restTemplate;
	
	@Value("${microservice.customer-service.endpoints.endpoint.uri}")
	private String PROD_ENDPOINT_URL;

	@Override
	public Customer saveCustomer(Customer customer) {
		return this.customerRepo.save(customer);
	}

	@Override
	public Customer getCustomer(int custId) {
		Customer customer=null;
		try {
			Optional<Customer> optional = this.customerRepo.findById(custId);
			customer=optional.get();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return customer;
	}

	@Override
	public List<Customer> getCustomers() {
		return this.customerRepo.findAll();
	}

	@Override
	public Myorders getMyOrders(int custId) {
		Myorders orders=new Myorders();
		Customer customer=new Customer();
		try {
			customer=this.customerRepo.findById(custId).get();
			orders.setCustomer(customer);
			int[] productIds = customer.getProductId();
			List<Product> products=new ArrayList<>();
			for(int pId: productIds) {
				Product product = this.restTemplate.getForObject(PROD_ENDPOINT_URL+pId, Product.class);
				products.add(product);
			}
			orders.setProducts(products);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return orders;
	}

}
