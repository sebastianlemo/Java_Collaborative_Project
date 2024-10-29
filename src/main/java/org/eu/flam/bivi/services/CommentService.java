package org.eu.flam.bivi.services;

import org.eu.flam.bivi.models.Book;
import org.eu.flam.bivi.models.Comment;
import org.eu.flam.bivi.models.User;
import org.eu.flam.bivi.repositories.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends BaseService<Comment> {

	private final CommentRepository repository;

	public CommentService(CommentRepository repository) {
		super(repository);
		this.repository = repository;
	}

	public void saveComment(Comment comment, Book book, User user) {
		comment.setBook(book);
		comment.setUser(user);
		repository.save(comment);
	}

}