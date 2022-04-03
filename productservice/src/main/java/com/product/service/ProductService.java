package com.product.service;

import java.util.List;

import com.product.entity.Product;


public interface ProductService {
	
	public Product saveProduct(Product prod);
	
	public Product getProduct(long pId);
	
	public List<Product> getProducts();

}
