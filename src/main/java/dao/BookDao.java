package dao;

import java.util.List;

import pojo.BookPojo;

public interface BookDao {
	BookPojo addBook(BookPojo bookPojo);
	BookPojo updateBook(BookPojo bookPojo);
	boolean deleteBook(int bookId);
	List<BookPojo> getAllBooks();
	BookPojo getABook(int bookId);
	void exitApplication();
	
}
