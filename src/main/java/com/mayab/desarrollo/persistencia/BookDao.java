package com.mayab.desarrollo.persistencia;

import java.util.ArrayList;

import com.mayab.desarrollo.entidades.Book;

public interface BookDao {
	public ArrayList<Book> findAll();
	public Book findByISBN(String isbn);
	public boolean saveBook(Book book);
	public boolean deleteBook(int id);
}
