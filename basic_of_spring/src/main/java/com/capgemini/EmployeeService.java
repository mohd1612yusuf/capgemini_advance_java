package com.capgemini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao dao;

	public void insertEmployee(Employee e) {
		if (dao.findById(e.getId()) == null) {
			dao.insert(e);
		} else {
			System.out.println("Data exists");
		}
	}
}
