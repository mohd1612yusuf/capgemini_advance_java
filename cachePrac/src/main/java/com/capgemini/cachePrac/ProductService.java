package com.capgemini.cachePrac;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	private ProductRepository repository;

	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}

	@CachePut(cacheNames = "product", key = "#result.id")
	public Product addProduct(Product p) {
		return repository.save(p);
	}

	@Cacheable(cacheNames = "product", key = "#id")
	public Product getById(int id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Id not present"));
	}

	@CachePut(cacheNames = "product", key = "#id")
	public Product updateById(int id, Product updatedProduct) {
		Product existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Id not present"));
		existing.setName(updatedProduct.getName());
		return repository.save(existing);
	}

	@CacheEvict(cacheNames = "product", key = "#id")
	public String deleteById(int id) {
		Product existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Id not present"));
		repository.delete(existing);
		return "Product deleted successfully";
	}
}