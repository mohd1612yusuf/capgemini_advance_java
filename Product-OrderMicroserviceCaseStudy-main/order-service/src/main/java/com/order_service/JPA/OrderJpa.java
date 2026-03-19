package com.order_service.JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order_service.entity.Order;

public interface OrderJpa extends JpaRepository<Order, Long> {
}
