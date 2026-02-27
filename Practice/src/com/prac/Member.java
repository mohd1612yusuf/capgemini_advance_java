package com.prac;

public class Member {

	private int id;
	private String name;
	private String city;
	private String membershipType; // PREMIUM / REGULAR

	public Member(int id, String name, String city, String membershipType) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.membershipType = membershipType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public String getMembershipType() {
		return membershipType;
	}
}