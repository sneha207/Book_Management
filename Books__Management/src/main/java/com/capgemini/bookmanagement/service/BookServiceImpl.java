package com.capgemini.bookmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.capgemini.bookmanagement.entity.Book;
import com.capgemini.bookmanagement.repository.BookRepository;



@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public void saveBook(Book book) {
		this.bookRepository.save(book);
	}

	@Override
	public Book getBookById(long id) {
		Optional<Book> optional = bookRepository.findById(id);
		Book book = null;
		if (optional.isPresent()) {
			book = optional.get();
		} else {
			throw new RuntimeException(" Book not found for id :: " + id);
		}
		return book;
	}

	@Override
	public void deleteBookById(long id) {
		this.bookRepository.deleteById(id);
	}

	@Override
	public Page<Book> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.bookRepository.findAll(pageable);
	}
}
