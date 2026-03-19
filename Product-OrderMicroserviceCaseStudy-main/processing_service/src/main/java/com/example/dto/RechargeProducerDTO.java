package com.example.dto;

import java.io.Serializable;

import lombok.Data;

public class RechargeProducerDTO implements Serializable {

	private String mobileNumber;
	private String operator;

	private double amount;

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}