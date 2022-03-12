package com.mayab.desarrollo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mayab.desarrollo.entidades.Book;

public class BookDaoImp implements BookDao {
	public static final String DRIVE_NAME = "com.sqlite.jdbc.Driver";
	public static final String DB_URL = "jdbc:sqlite:C:\\Users\\wario\\eclipse-workspace\\dao\\Databases\\Library.db";
	public static final String ID = "";
	public static final String PASS = "";
	
	private Connection getConnection() {
		try{
			return DriverManager.getConnection(DB_URL, ID, PASS);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	private static void close(Connection con) {
		if(con != null) {
			try {
				con.close();
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public BookDaoImp() {
		
	}
	
	@Override
	public ArrayList<Book> findAll(){
		return new ArrayList<Book>();
	}
	@Override
	public Book findByISBN(String isbn) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = getConnection();
			stmt = con.prepareStatement("SELECT id, name, ISBN FROM Book WHERE ISBN = ?", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,isbn);
			
			
			int result = stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			
			
			return new Book(rs.getString(2),rs.getString(3));
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}finally {
			close(con);
		}
	}
	@Override
	public boolean saveBook(Book book) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = getConnection();
			stmt = con.prepareStatement("INSERT INTO Book(id, name, ISBN) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			//stmt.setInt(1,book.getId());
			stmt.setString(2,book.getName());
			stmt.setString(3,book.getISBN());
			
			int result = stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			
			
			if(result == 1) {
				return true;
			}
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}finally {
			close(con);
		}
		
		return false;
	}
	@Override
	public boolean deleteBook(int id) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = getConnection();
			stmt = con.prepareStatement("DELETE FROM Book WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1,id);

			
			int result = stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			
			
			if(result == 1) {
				return true;
			}
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}finally {
			close(con);
		}
		return false;
	}

}
