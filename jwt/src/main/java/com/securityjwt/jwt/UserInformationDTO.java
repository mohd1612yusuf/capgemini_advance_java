package com.securityjwt.jwt;

public class UserInformationDTO {
	private String emailId;
	private String password;
	private String name;
	private String phone;

	public UserInformationDTO(String emailId, String password, String name, String phone) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
