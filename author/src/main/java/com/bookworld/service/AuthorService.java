package com.bookworld.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworld.domain.Author;
import com.bookworld.service.repository.AuthorRepository;

@Service
public class AuthorService {

	private final AuthorRepository authorRepository;

	@Autowired
	public AuthorService(final AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	public Collection<Author> getAuthors() {
		return authorRepository.getAuthors();
	}

}
