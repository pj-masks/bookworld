package com.bookworld.repository;

import java.util.Collection;

import com.bookworld.domain.Book;

public interface BookRepository {

	Collection<Book> getBooks();

	Book save(Book book);

}
