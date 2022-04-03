package com.product.controller;

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

import com.product.entity.Product;
import com.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/")
	public ResponseEntity<Product> saveProduct(@RequestBody Product prod) {
		Product product=null;
		if(prod!=null) {
			product = this.productService.saveProduct(prod);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}
		return new ResponseEntity<Product>(product, HttpStatus.NO_CONTENT);
		
	}
	
	@GetMapping("/{pId}")
	public ResponseEntity<Product> getProduct(@PathVariable("pId") int id) {
		long pId=(long)id;
		Product product = this.productService.getProduct(pId);
		if(product!=null) {
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}
		return new ResponseEntity<Product>(product, HttpStatus.NOT_FOUND);
		
	}

	@GetMapping("/")
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> products = this.productService.getProducts();
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		
	}
}
