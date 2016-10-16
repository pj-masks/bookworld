package com.bookworld;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookworld.domain.Book;
import com.bookworld.service.BookService;

@RestController
public class BookController {

	private final BookService bookService;

	@Autowired
	public BookController(final BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public ResponseEntity<Collection<Book>> getBooks() {
		return new ResponseEntity<Collection<Book>>(bookService.getBooks(), HttpStatus.OK);
	}

	@RequestMapping(value = "/books", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> create(@RequestBody Book book) {
		return new ResponseEntity<Book>(bookService.create(book), HttpStatus.OK);
	}

}
