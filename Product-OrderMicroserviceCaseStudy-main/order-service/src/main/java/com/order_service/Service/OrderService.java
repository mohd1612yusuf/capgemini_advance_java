package com.order_service.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.order_service.DTO.OrderRequestDTO;
import com.order_service.DTO.ProductDTO;
import com.order_service.JPA.OrderJpa;
import com.order_service.ProductService.ProductService;
import com.order_service.entity.Order;

@Service
public class OrderService {
	private final ProductService ps;
	private final OrderJpa ojpa;

	public OrderService(OrderJpa ojpa, ProductService ps) {
		this.ojpa = ojpa;
		this.ps = ps;
	}

	@CircuitBreaker(name = "productService", fallbackMethod = "createOrderFallBack")
	public Order createOrder(OrderRequestDTO order) {
		ProductDTO product = ps.getBookById(order.getId());
		if (product == null)
			return null;
		Order orders = new Order();
		orders.setDescription(product.getDescription());
		orders.setQuantity(order.getQuantity());
		orders.setPrice(order.getQuantity() * product.getPrice());
		orders.setName(product.getName());
		orders.setOrderId(order.getId());
		return ojpa.save(orders);
	}

	public Order getOrderById(Long id) {
		Optional<Order> option = ojpa.findById(id);
		if (option.isPresent()) {
			return option.get();
		}
		return null;
	}

	public List<Order> getAllOrder() {
		return ojpa.findAll();
	}

	public String deleteOrderById(Long id) {
		Optional<Order> option = ojpa.findById(id);
		if (option.isPresent()) {
			ojpa.delete(option.get());
		}
		return "deleted";
	}

	public String createOrderFallBack(OrderRequest request, Throwable ex) {
		return "Product service not active";
	}
}
