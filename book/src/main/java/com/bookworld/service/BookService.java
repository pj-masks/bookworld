package com.bookworld.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworld.domain.Book;
import com.bookworld.repository.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;

	@Autowired
	public BookService(final BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public Collection<Book> getBooks() {
		return bookRepository.getBooks();
	}

	public Book create(Book book) {
		return bookRepository.save(book);
	}

}
