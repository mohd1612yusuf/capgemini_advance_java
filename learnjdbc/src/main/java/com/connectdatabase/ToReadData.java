package com.connectdatabase;

import java.sql.*;
import java.util.Scanner;

public class ToReadData {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String url = "jdbc:postgresql://localhost:5432/college";
		String un = "postgres";
		String pwd = "root";
		try {
//			Class.forName("org.postgresql.Driver");
			Connection connect = DriverManager.getConnection(url, un, pwd);
			String sql = "insert into student values(?, ?, ?)";
			PreparedStatement pstm = connect.prepareStatement(sql);
			System.out.println("Enter id: ");
			int id=scan.nextInt();
			pstm.setInt(1, id);
			System.out.println("Enter name: ");
			String name=scan.next();
			pstm.setString(2, name);
			System.out.println("Enter branch: ");
			String branch=scan.next();
			pstm.setString(3, branch);
			pstm.execute();
			pstm.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
