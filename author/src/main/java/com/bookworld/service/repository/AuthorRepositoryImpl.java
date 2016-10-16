package com.bookworld.service.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.bookworld.domain.Author;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

	private final NamedParameterJdbcOperations jdbcOperations;
	private final DataSource dataSource;

	private final static String INSERT_AUTHOR = "insert into author ( author_id, first_name, last_name) "
			+ "values (author_seq.nextval, :first_name, :last_name)";

	@Autowired
	public AuthorRepositoryImpl(final NamedParameterJdbcOperations jdbcOperations, final DataSource dataSource) {
		this.jdbcOperations = jdbcOperations;
		this.dataSource = dataSource;
		
	}

	public Collection<Author> getAuthors() {
		return jdbcOperations.query("select * from author", (rs, rowNum) -> {
			return new Author(rs.getInt("AUTHOR_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"));
		});
	}

	@Override
	public void create(Author author) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource).withCatalogName("CREATE_AUTHOR").withProcedureName("CREATE_AUTHOR");
		MapSqlParameterSource in = new MapSqlParameterSource();
		    in.addValue("FIRST_NAME", author.getFirstName());
		    in.addValue("LAST_NAME", author.getLastName());
		    simpleJdbcCall.execute(in);
		
	}

	/*@Override
	public void create(Author author) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("first_name", author.getFirstName());
		paramMap.put("last_name", author.getLastName());
		jdbcOperations.update(INSERT_AUTHOR, paramMap);
	}*/

}
