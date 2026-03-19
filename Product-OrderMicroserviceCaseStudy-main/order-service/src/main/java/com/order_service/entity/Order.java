package com.order_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_service")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator = "order_seq")
	@SequenceGenerator(name="order_seq" , sequenceName="order_sequence" , initialValue=10000 , allocationSize = 1)
	Long id ; 
	@Column(nullable = false)
	Long orderId ;
	String name ;
	String description ; 
	double price ; 
	int quantity ;
	public Order() {
		// nothing to write for best practice 
	}
	public Order(Long id, Long orderId, String name , String description, double price, int quantity) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.name = name ;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrderId() {
		return orderId;
	}
	public String getName() {
		return name ;
	}
	public void setName(String name) {
		this.name = name ;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderId=" + orderId + ", description=" + description + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
}
