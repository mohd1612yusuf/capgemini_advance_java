package com.prac;

class BookNotAvailableException extends RuntimeException {
	public BookNotAvailableException(String msg) {
		super(msg);
	}
}