package com.capgemini.cachePrac;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	private ProductService service;

	public ProductController(ProductService service) {
		super();
		this.service = service;
	}

	@PostMapping("create")
	public Product addProduct(@RequestBody Product p) {
		return service.addProduct(p);
	}

	@GetMapping("find-id/{id}")
	public Product getProductById(@PathVariable int id) {
		return service.getById(id);
	}

	@PutMapping("update/{id}")
	public Product updateProduct(@PathVariable int id, @RequestBody Product p) {
		return service.updateById(id, p);
	}

	@DeleteMapping("delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteById(id);
	}
}
