package com.bookworld.service.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import com.bookworld.domain.Author;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

	private final JdbcOperations jdbcOperations;

	@Autowired
	public AuthorRepositoryImpl(final JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}

	public Collection<Author> getAuthors() {
		return jdbcOperations.query("select * from author", (rs, rowNum) -> {
			return new Author(rs.getInt("AUTHOR_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"));
		});
	}

}
