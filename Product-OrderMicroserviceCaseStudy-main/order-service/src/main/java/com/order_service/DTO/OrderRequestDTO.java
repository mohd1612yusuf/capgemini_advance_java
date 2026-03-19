package com.order_service.DTO;

public class OrderRequestDTO {
	Long id ;  // for the product dto 
	int quantity ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	} 
}
