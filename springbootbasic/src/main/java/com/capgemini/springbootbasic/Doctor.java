package com.capgemini.springbootbasic;

import org.springframework.stereotype.Component;

@Component
//@Scope("request")
public class Doctor {

	public void check() {
		System.out.println("Temp");
	}
}
