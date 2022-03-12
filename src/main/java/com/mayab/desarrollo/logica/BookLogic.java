package com.mayab.desarrollo.logica;
import com.mayab.desarrollo.entidades.Book;
import com.mayab.desarrollo.persistencia.BookDaoImp;

public class BookLogic {
	public BookLogic() {
		
	}
	
	public void addBook(Book book) {
		BookDaoImp dao = new BookDaoImp();
		dao.saveBook(book);
	}
	
	public void deleteBook(int id) {
		BookDaoImp dao = new BookDaoImp();
		dao.deleteBook(id);
	}
	
	public Book findByISBN (String ISBN) {
		BookDaoImp dao = new BookDaoImp();
		return dao.findByISBN(ISBN);
	}
}
