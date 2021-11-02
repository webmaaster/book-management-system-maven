package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.BookPojo;

public class BookJdbcDaoImpl implements BookDao {

	@Override
	public BookPojo addBook(BookPojo bookPojo) {		
		return null;
	}

	@Override
	public BookPojo updateBook(BookPojo bookPojo) {
		return null;
	}

	@Override
	public boolean deleteBook(int bookId) {
		Connection conn = DBUtil.makeConnection();
		System.out.println(bookId);
		int rowsAffected = 0;
		try {
			Statement stmt = conn.createStatement();
			// here we are not going to do a hard delete, we are going 
			// for a soft delete.
			String query = "update book_details set book_removed=true where book_id="+bookId;
			rowsAffected = stmt.executeUpdate(query);
			System.out.println(rowsAffected);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rowsAffected == 0)
			return false;
		else
			return true;
	}

	@Override
	public List<BookPojo> getAllBooks() {
		// create a empty collection which is going to hold all the reords from the DB
		// as pojo Object
		List<BookPojo> allBooksStore = new ArrayList<BookPojo>();

		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String query = "select * from book_details where book_removed=false";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				// here as we iterate through the rs we should
				// each record in a pojo object and
				// add it to the collection
				// and at the end we return the collection

				// as we iterate we are taking each record and storing it in a bookPojo object
				BookPojo bookPojo = new BookPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5), rs.getBoolean(6));

				// add the bookPojo obj to a collection
				allBooksStore.add(bookPojo);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return allBooksStore;

	}

	@Override
	public BookPojo getABook(int bookId) {
		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		BookPojo bookPojo = null;
		try {
			stmt = conn.createStatement();
			String query = "select * from book_details where book_id="+bookId;
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				bookPojo = new BookPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5), rs.getBoolean(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookPojo;
	}

}
