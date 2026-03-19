package com.product_service.controller;

import org.springframework.web.bind.annotation.*;

import com.product_service.Service.ProductService;
import com.product_service.entity.Product;
import java.util.*;


@RestController
public class ProductController {
	private final ProductService ps ;
	public ProductController(ProductService ps) {
		this.ps = ps ; 
	}
	
	@PostMapping("/create")
	public Product addProduct(@RequestBody Product p) {
		return ps.createProduct(p) ; 
	}
	
	@GetMapping("/get/{id}")
	public Product getProductById(@PathVariable Long id) {
		return ps.getProductById(id) ; 
	}
	
	@GetMapping("/get/all")
	public List<Product> getAllProduct() {
		return ps.getAllProduct() ;
	}
	
	@PutMapping("/get/{id}")
	public Product updateProductById(@PathVariable Long id , @RequestBody Product p) {
		return ps.updateProduct(id, p ) ; 
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable Long id) {
		return ps.deleteProduct(id) ;
	}
	
	@GetMapping("/get/hi")
	public String getHii() {
		return "hii from the product service" ;
	}
	
}
