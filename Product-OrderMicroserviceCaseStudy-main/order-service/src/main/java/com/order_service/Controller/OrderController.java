package com.order_service.Controller;

import org.springframework.web.bind.annotation.*;

import com.order_service.DTO.OrderRequestDTO;
import com.order_service.DTO.ProductDTO;
import com.order_service.ProductService.ProductService;
import com.order_service.Service.OrderService;
import com.order_service.entity.Order;
import java.util.*;

@RestController
public class OrderController {
	
	private final ProductService ps ;
	private final OrderService os ;
	public OrderController(OrderService os , ProductService ps) {
		this.os = os ; 
		this.ps = ps ;
	}
	@PostMapping("/create")
	public Order createOrder(@RequestBody OrderRequestDTO order) {
		return os.createOrder(order) ;
	}
	
	@GetMapping("/get/{id}")
	public Order getOrderById(@RequestBody Long id) {
		return os.getOrderById(id) ; 
	}
	
	@GetMapping("/get/all")
	public List<Order> getAllOrder(){
		return os.getAllOrder() ; 
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteOrder(@PathVariable Long id) {
		return os.deleteOrderById(id) ;
	}
	
	@GetMapping("/get/hi")
	public String getHii() {
		return "hii from the order service" ;
	}
	
	@GetMapping("/get/product")
	public String getHiiFromProduct() {
		return ps.getHiiFromOrder() ;
	}
	
}
