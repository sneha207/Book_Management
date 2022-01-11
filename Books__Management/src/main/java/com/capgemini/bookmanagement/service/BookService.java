package com.capgemini.bookmanagement.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.bookmanagement.entity.Book;


public interface BookService {
	List<Book> getAllBooks();
	void saveBook(Book book);
	Book getBookById(long id);
	void deleteBookById(long id);
	Page<Book> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
