package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dao.ProductRepo;
import com.product.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepo prodRepo;

	@Override
	public Product saveProduct(Product prod) {
		Product product = this.prodRepo.save(prod);
		return product;
	}

	@Override
	public Product getProduct(long pId) {
		Product prod=null;
		try {
			Optional<Product> optional = this.prodRepo.findById(pId);
			if(optional!=null) {
				prod=optional.get();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return prod;
	}

	@Override
	public List<Product> getProducts() {
		return this.prodRepo.findAll();
	}

}
