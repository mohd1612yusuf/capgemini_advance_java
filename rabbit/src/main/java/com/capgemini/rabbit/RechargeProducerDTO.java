package com.capgemini.rabbit;

public class RechargeProducerDTO {

	private String mobilenumber;
	private double amount;

	public RechargeProducerDTO() {
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}