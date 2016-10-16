package com.bookworld.repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookworld.domain.Book;

@Repository
@Transactional
public class BookRepositoryImpl implements BookRepository {

	private SessionFactory sessionFactory;

	@Autowired
	public BookRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Book> getBooks() {
		return (List<Book>) currentSession().createCriteria(Book.class).list();

	}

	@Override
	public Book save(Book book) {
		Serializable id = currentSession().save(book);
		return new Book((Integer) id, book.getTitle());
	}

}
