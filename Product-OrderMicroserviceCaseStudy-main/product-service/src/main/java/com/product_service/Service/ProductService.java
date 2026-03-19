package com.product_service.Service;

import org.springframework.stereotype.Service;

import com.product_service.JPA.ProductJpa;
import com.product_service.entity.Product;
import java.util.*;

@Service
public class ProductService {
	
	private final ProductJpa pjpa ;
	public ProductService(ProductJpa pjpa) {
		this.pjpa = pjpa ;
	}
	public Product createProduct(Product p) {
		return pjpa.save(p) ;
	}
	
	public Product getProductById(Long id) {
		Optional<Product> option = pjpa.findById(id) ; 
		if(option.isPresent()) {
			return option.get() ; 
		}
		return null ; // not present 
	}
	
	public List<Product> getAllProduct(){
		return pjpa.findAll() ; 
	}
	
	public Product updateProduct(Long id  , Product product) {
		Optional<Product> option = pjpa.findById(id) ; 
		if(option.isPresent()) {
			Product p = option.get()  ; 
			p.setDescription(product.getDescription());
			p.setName(product.getName()) ;
			p.setPrice(product.getPrice());
			return pjpa.save(p) ; 
		}
		return null ;
	}
	
	public String deleteProduct(Long id) {
		Optional<Product> option = pjpa.findById(id) ; 
		if(option.isPresent()) {
			pjpa.delete(option.get());
		}
		return "deleted" ;
	}
	
}
