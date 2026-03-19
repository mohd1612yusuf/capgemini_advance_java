package com.product_service.JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product_service.entity.Product;

public interface ProductJpa  extends JpaRepository<Product, Long>   {

}
