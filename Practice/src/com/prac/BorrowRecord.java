package com.prac;

public class BorrowRecord {

	private Book book;
	private Member member;
	private boolean returned;

	public BorrowRecord(Book book, Member member) {
		this.book = book;
		this.member = member;
		this.returned = false;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public void setReturned(boolean returned) {
		this.returned = returned;
	}

	public Book getBook() {
		return book;
	}

	public Member getMember() {
		return member;
	}

	public boolean isReturned() {
		return returned;
	}

	public void markReturned() {
		this.returned = true;
	}
}