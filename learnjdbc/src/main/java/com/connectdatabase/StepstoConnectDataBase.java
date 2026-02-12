package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StepstoConnectDataBase {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/college";
		String un = "postgres";
		String pwd = "root";
		try {
			Class.forName("org.postgresql.Driver");
			Connection connect = DriverManager.getConnection(url, un, pwd);
			String sql="insert into student values(1,'Miller','CSE')";
			System.out.println("Connection created");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}