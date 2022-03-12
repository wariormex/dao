package com.mayab.desarrollo.dao;

import com.mayab.desarrollo.entidades.Book;
import com.mayab.desarrollo.logica.BookLogic;

public class App {

	public static void main(String[] args) {
		Book book = new Book("libro1","1234");
		BookLogic logic = new BookLogic();
		
		logic.addBook(book);
		//logic.deleteBook(0);
		//Book foundBook = logic.findByISBN("1234");
		
		//System.out.println("Found book: " + foundBook.getName());
	}

}
