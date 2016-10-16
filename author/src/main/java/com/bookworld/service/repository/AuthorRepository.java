package com.bookworld.service.repository;

import java.util.Collection;

import com.bookworld.domain.Author;

public interface AuthorRepository {
	Collection<Author> getAuthors();

	void create(Author author);
}
