package service;

import java.util.List;

import dao.BookDao;
import dao.BookDaoImpl;
import dao.BookJdbcDaoImpl;
import pojo.BookPojo;

public class BookServiceImpl implements BookService{

	BookDao bookDao;
	
	public BookServiceImpl() {
		//this.bookDao = new BookDaoImpl();
		this.bookDao = new BookJdbcDaoImpl();
	}

	@Override
	public BookPojo addBook(BookPojo bookPojo) {
		return this.bookDao.addBook(bookPojo);
	}

	@Override
	public BookPojo updateBook(BookPojo bookPojo) {
		return this.bookDao.updateBook(bookPojo);
	}

	@Override
	public boolean deleteBook(int bookId) {
		return this.bookDao.deleteBook(bookId);
	}

	@Override
	public List<BookPojo> getAllBooks() {
		return this.bookDao.getAllBooks();
	}

	@Override
	public BookPojo getABook(int bookId) {
		return this.bookDao.getABook(bookId);
	}

	@Override
	public void exitApplication() {
		// TODO Auto-generated method stub
		
	}

}
