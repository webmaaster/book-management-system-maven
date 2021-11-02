package dao;

import java.util.ArrayList;
import java.util.List;

import pojo.BookPojo;

public class BookDaoImpl implements BookDao{

	List<BookPojo> allBooksStore;
	
	public BookDaoImpl() {
		this.allBooksStore = new ArrayList<BookPojo>();
	}

	@Override
	public BookPojo addBook(BookPojo bookPojo) {
		bookPojo.setBookId(allBooksStore.size() + 1);
		allBooksStore.add(bookPojo);
		return bookPojo;
	}

	@Override
	public BookPojo updateBook(BookPojo bookPojo) {
		System.out.println(bookPojo.getBookId());
		for(int i=0; i<allBooksStore.size(); i++) {
			System.out.println(allBooksStore.get(i).getBookId());
			if(allBooksStore.get(i).getBookId() == bookPojo.getBookId()) {
				System.out.println("Match found!");
				allBooksStore.set(i, bookPojo);
				break;
			}
		} 
		return bookPojo;
	}

	@Override
	public boolean deleteBook(int bookId) {
		int currentSize = allBooksStore.size();
		allBooksStore.removeIf(bookPojo -> bookPojo.getBookId() == bookId );
		int nowSize = allBooksStore.size();
		if(currentSize == nowSize) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public List<BookPojo> getAllBooks() {
		return allBooksStore;
	}

	@Override
	public BookPojo getABook(int bookId) {
		for(BookPojo bookPojo: allBooksStore) {
			if(bookPojo.getBookId() == bookId) {
				return bookPojo;
			}
		}
		return null;
	}

	

}
