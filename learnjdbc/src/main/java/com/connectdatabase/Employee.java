package com.connectdatabase;

import java.sql.*;
import java.util.Scanner;

public class Employee {
	public static void findEmpById(Connection connect) {
		Scanner scan = new Scanner(System.in);
		try {
			String sql = "select * from employee where id=?";
			PreparedStatement pstm = connect.prepareStatement(sql);
			System.out.println("Enter employee id: ");
			int id = scan.nextInt();
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				System.out.println("Employee Details:");
				System.out.println("ID     : " + rs.getInt("id"));
				System.out.println("Name   : " + rs.getString("name"));
				System.out.println("Salary : " + rs.getInt("salary"));
			} else {
				System.out.println("Employee not found with ID: " + id);
			}
			rs.close();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateEmpSalById(Connection connect) {
		Scanner scan = new Scanner(System.in);
		try {
			String sql = "update employee set salary=? where id=?";
			PreparedStatement pstm = connect.prepareStatement(sql);
			System.out.println("Enter salary: ");
			int salary = scan.nextInt();
			pstm.setInt(1, salary);
			System.out.println("Enter id: ");
			int id = scan.nextInt();
			pstm.setInt(2, id);
			pstm.execute();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteEmpById(Connection connect) {
		Scanner scan = new Scanner(System.in);
		try {
			String sql = "delete from employee where id=?";
			PreparedStatement pstm = connect.prepareStatement(sql);
			System.out.println("Enter id: ");
			int id = scan.nextInt();
			pstm.setInt(1, id);
			pstm.execute();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addEmployee(Connection connect) {
		Scanner scan = new Scanner(System.in);
		try {
			String sql = "insert into employee values(?, ?, ?)";
			PreparedStatement pstm = connect.prepareStatement(sql);
			System.out.println("Enter id: ");
			int id = scan.nextInt();
			pstm.setInt(1, id);
			System.out.println("Enter name: ");
			String name = scan.next();
			pstm.setString(2, name);
			System.out.println("Enter salary: ");
			int salary = scan.nextInt();
			pstm.setInt(3, salary);
			pstm.execute();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/school";
		String un = "postgres";
		String pwd = "root";
		try {
			Connection connect = DriverManager.getConnection(url, un, pwd);
//			addEmployee(connect);
//			deleteEmpById(connect);
//			updateEmpSalById(connect);
			findEmpById(connect);
			connect.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}