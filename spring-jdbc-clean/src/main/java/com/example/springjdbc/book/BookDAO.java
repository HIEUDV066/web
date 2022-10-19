package com.example.springjdbc.book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
public class BookDAO {
	private String jdbcURL="jdbc:mysql://localhost:3306/jdbc_demo";
	private String jdbcUsername="root";
	private String jdbcPassword="123456";
	private static final String SELECT_ALL_BOOKS="select * from book_store";
	private static final String SELECT_BOOK_BY_ID="select * from book_store where bookcode=?";
	private static final String INSERT_BOOKS_SQL="INSERT INTO book_store VALUES (?, ?, ?, ?, ?)";
	private static final String UPDATE_BOOKS_SQL ="UPDATE book_store SET title=?, author=?,category=?,approved=? where bookcode=?";
	private static final String DELETE_BOOKS_SQL="DELETE FROM book_store WHERE bookcode=?";
	public BookDAO() {
	}
	protected Connection getConnection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	public List<Book> selectAllBooks(){
		List<Book> books=new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_BOOKS);)
		{
		ResultSet rs= preparedStatement.executeQuery();
		while(rs.next()) {
			int bookcode=rs.getInt("bookcode");
			String title=rs.getString("title");
			String author=rs.getString("author");
			String category=rs.getString("category");
			int approved= rs.getInt("approved");
			books.add(new Book(bookcode,title, author, category, approved==0 ? false:true));
			
		}
				
			
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
		return books;
		
	}
	public Book selectBook(int id) {
		Book book=new Book();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(SELECT_BOOK_BY_ID);)
				
		{
		preparedStatement.setInt(1,id);
		ResultSet rs= preparedStatement.executeQuery();
		while(rs.next()) {
			book.setBookcode(rs.getInt("bookcode"));
			book.setTitle(rs.getString("title"));
			book.setAuthor(rs.getString("author"));
			book.setCategory(rs.getString("category"));
			book.setApproved(rs.getInt("approved") !=0 ? true : false);
			
			
		}
				
			
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
		return book;
	}
	public void insertBook(Book book) throws SQLException {
		try(Connection connection=getConnection();
				PreparedStatement ps=connection.prepareStatement(INSERT_BOOKS_SQL)){
			ps.setInt(1, Integer.valueOf(book.getBookcode()));
			ps.setString(2,book.getTitle());
			ps.setString(3,book.getAuthor());
			ps.setString(4,book.getCategory());
			ps.setInt(5, book.isApproved()?1:0);
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void updateBook(Book book) throws SQLException {
		try(Connection connection=getConnection();
				PreparedStatement ps=connection.prepareStatement(UPDATE_BOOKS_SQL)){
			ps.setString(1,book.getTitle());
			ps.setString(2,book.getAuthor());
			ps.setString(3, book.getCategory());
			ps.setInt(4,book.isApproved()?1:0);
			ps.setInt(5, Integer.valueOf(book.getBookcode()));
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	} 
	public void deleteBook(int id) {
		
		try(Connection connection=getConnection();
				PreparedStatement ps=connection.prepareStatement(DELETE_BOOKS_SQL)){
			ps.setInt(1,id);
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
