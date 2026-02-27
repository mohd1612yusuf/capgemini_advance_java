package com.prac;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
	private int orderId;
	private String customerName;
	private String category;
	private double amount;
	private String city;
	private String status;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerName=" + customerName + ", category=" + category + ", amount="
				+ amount + ", city=" + city + ", status=" + status + "]";
	}

	public Order(int orderId, String customerName, String category, double amount, String city, String status) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.category = category;
		this.amount = amount;
		this.city = city;
		this.status = status;
	}

	public static List<Order> getOrders() {
		List<Order> li = new ArrayList<Order>();
		li.add(new Order(1, "Yusuf", "Electronics", 75000, "Delhi", "PAID"));
		li.add(new Order(2, "Rahul", "Fashion", 25000, "Mumbai", "PAID"));
		li.add(new Order(3, "Aman", "Electronics", 55000, "Delhi", "CANCELLED"));
		li.add(new Order(4, "Sneha", "Grocery", 5000, "Chennai", "PAID"));
		li.add(new Order(5, "Priya", "Fashion", 65000, "Bangalore", "PAID"));
		li.add(new Order(6, "Rohit", "Electronics", 95000, "Delhi", "PAID"));
		li.add(new Order(7, "Meera", "Furniture", 45000, "Pune", "PENDING"));
		li.add(new Order(8, "Karan", "Furniture", 85000, "Mumbai", "PAID"));
		return li;
	}

	public static void main(String[] args) {
//		getPaidOrders();
//		countTotalOrders();
//		revenueFromPaidOrders();
//		highestValueOrder();
//		lowestValueOrder();
//		uniqueNames();
		ordersAbove50000();
	}

	public static void getPaidOrders() {
		getOrders().stream().filter(o -> o.getStatus().equals("PAID")).forEach(System.out::println);
	}

	public static void countTotalOrders() {
		long res = getOrders().stream().count();
		System.out.println(res);
	}

	public static void revenueFromPaidOrders() {
		double res = getOrders().stream().filter(o -> o.getStatus().equals("PAID")).mapToDouble(Order::getAmount).sum();
		System.out.println(res);
	}

	public static void highestValueOrder() {
		double max = getOrders().stream().mapToDouble(e -> e.getAmount()).max().orElse(0);
		System.out.println(max);
		List<Order> res = getOrders().stream().filter(e -> e.getAmount() == max).collect(Collectors.toList());
		System.out.println(res);
	}

	public static void lowestValueOrder() {
		double min = getOrders().stream().filter(e -> e.getStatus().equals("PAID")).mapToDouble(e -> e.getAmount())
				.min().orElse(0);
		System.out.println(min);
		List<Order> res = getOrders().stream().filter(e -> e.getAmount() == min).collect(Collectors.toList());
		System.out.println(res);
	}

	public static void uniqueNames() {
		getOrders().stream().map(e -> e.getCustomerName()).distinct().forEach(System.out::println);
	}

	public static void ordersAbove50000() {
		getOrders().stream().filter(e -> e.getAmount() > 50000).map(e -> e.getCustomerName()).distinct()
				.forEach(System.out::println);
	}
	
	public static void sortByAmount() {
		getOrders().stream().sorted((e1,e2)->(e2.getAmount()-e1.getAmount()).forEach(System.out::println);
	}
}
