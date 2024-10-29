package org.eu.flam.bivi.services;

import java.util.List;

import org.eu.flam.bivi.models.Book;
import org.eu.flam.bivi.models.User;
import org.eu.flam.bivi.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService extends BaseService<Book> {

	private final BookRepository repository;

	public BookService(BookRepository repository) {
		super(repository);
		this.repository = repository;
	}

	public void saveBook(Book book, User user) {
		book.setUser(user);
		repository.save(book);
	}

	public List<Book> findByCreatedAt() {
		return repository.findTop3ByOrderByCreatedAtDesc();
	}

	public List<Book> findByTitle(String title) {
		return repository.findByTitleContaining(title);
	}

}