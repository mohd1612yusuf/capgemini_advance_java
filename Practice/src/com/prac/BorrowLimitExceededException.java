package com.prac;

class BorrowLimitExceededException extends RuntimeException {
	public BorrowLimitExceededException(String msg) {
		super(msg);
	}
}