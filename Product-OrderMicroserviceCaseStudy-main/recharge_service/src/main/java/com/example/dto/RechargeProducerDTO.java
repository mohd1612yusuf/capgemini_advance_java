package com.example.dto;

import java.io.Serializable;

import lombok.Data;

public class RechargeProducerDTO implements Serializable {

	private String mobileNumber;
	private double amount;
	private String operator;

	public RechargeProducerDTO() {
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

}