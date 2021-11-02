package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.BookPojo;

public class BookJdbcDaoImpl implements BookDao{

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
		return false;
	}

	@Override
	public List<BookPojo> getAllBooks() {
		// create a empty collection which is going to hold all the reords from the DB as pojo Object
		List<BookPojo> allBooksStore = new ArrayList<BookPojo>();
		
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
			if(conn != null) {
				System.out.println("Established connection to DB....");
			}
			
			Statement stmt = conn.createStatement();
			String query = "select * from book_details where book_removed=false";
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				// here as we iterate through the rs we should
				// each record in a pojo object and 
				// add it to the collection
				// and at the end we return the collection
				
				// as we iterate we are taking each record and storing it in a bookPojo object
				BookPojo bookPojo = new BookPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getBoolean(6));
				
				// add the bookPojo obj to a collection
				allBooksStore.add(bookPojo);
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allBooksStore;
	
	}

	@Override
	public BookPojo getABook(int bookId) {
		return null;
	}
	
	

}
