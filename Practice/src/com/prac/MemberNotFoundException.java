package com.prac;

class MemberNotFoundException extends RuntimeException {
	public MemberNotFoundException(String msg) {
		super(msg);
	}
}