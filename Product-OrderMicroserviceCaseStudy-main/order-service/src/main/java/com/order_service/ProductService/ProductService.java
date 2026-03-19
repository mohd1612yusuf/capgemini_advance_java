package com.order_service.ProductService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.order_service.DTO.ProductDTO;

@FeignClient(name="PRODUCT-SERVICE")
public interface ProductService {
	
	@GetMapping("/product/get/hi")
	public String getHiiFromOrder() ;
	
	@GetMapping("/product/get/{id}")
	public ProductDTO getBookById(@PathVariable Long id) ; 
}
