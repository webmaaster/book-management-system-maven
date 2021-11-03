package service;

import java.util.List;

import pojo.BookPojo;

public interface BookService {
	BookPojo addBook(BookPojo bookPojo);
	BookPojo updateBook(BookPojo bookPojo);
	boolean deleteBook(int bookId);
	List<BookPojo> getAllBooks();
	BookPojo getABook(int bookId);
	void exitApplication();
}
