package com.prac;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class LibraryService {

	private List<Book> books = new ArrayList<>();
	private List<Member> members = new ArrayList<>();
	private List<BorrowRecord> records = new ArrayList<>();

	private final int BORROW_LIMIT = 3;

	public void addBook(Book book) {
		books.add(book);
	}

	public void addMember(Member member) {
		members.add(member);
	}

	public void borrowBook(int memberId, int bookId) {

		Member member = members.stream().filter(m -> m.getId() == memberId).findFirst()
				.orElseThrow(() -> new MemberNotFoundException("Member not found"));

		Book book = books.stream().filter(b -> b.getId() == bookId).findFirst()
				.orElseThrow(() -> new BookNotAvailableException("Book not found"));

		if (book.getAvailableCopies() <= 0)
			throw new BookNotAvailableException("No copies available");

		long activeBorrows = records.stream().filter(r -> r.getMember().getId() == memberId && !r.isReturned()).count();

		if (activeBorrows >= BORROW_LIMIT)
			throw new BorrowLimitExceededException("Borrow limit exceeded");

		book.decreaseCopies();
		records.add(new BorrowRecord(book, member));
	}

	public void returnBook(int memberId, int bookId) {

		BorrowRecord record = records.stream()
				.filter(r -> r.getMember().getId() == memberId && r.getBook().getId() == bookId).findFirst()
				.orElseThrow(() -> new InvalidReturnException("Record not found"));

		if (record.isReturned())
			throw new InvalidReturnException("Already returned");

		record.markReturned();
		record.getBook().increaseCopies();
	}

	public long totalBorrowedCount() {
		return records.size();
	}

	public Optional<Book> mostBorrowedBook() {
		return records.stream().collect(Collectors.groupingBy(r -> r.getBook(), Collectors.counting())).entrySet()
				.stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
	}

	public Map<String, Long> borrowCountPerCategory() {
		return records.stream().collect(Collectors.groupingBy(r -> r.getBook().getCategory(), Collectors.counting()));
	}

	public List<Member> activeMembers() {
		return records.stream().filter(r -> !r.isReturned()).map(BorrowRecord::getMember).distinct()
				.collect(Collectors.toList());
	}

	public Map<String, List<Member>> membersByCity() {
		return members.stream().collect(Collectors.groupingBy(Member::getCity));
	}

	public Map<Boolean, List<Member>> partitionPremium() {
		return members.stream().collect(Collectors.partitioningBy(m -> m.getMembershipType().equals("PREMIUM")));
	}

	public Map<String, Double> averagePriceByCategory() {
		return books.stream()
				.collect(Collectors.groupingBy(Book::getCategory, Collectors.averagingDouble(Book::getPrice)));
	}

	public List<Book> top3BorrowedBooks() {
		return records.stream().collect(Collectors.groupingBy(r -> r.getBook(), Collectors.counting())).entrySet()
				.stream().sorted(Map.Entry.<Book, Long>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey)
				.collect(Collectors.toList());
	}
}
