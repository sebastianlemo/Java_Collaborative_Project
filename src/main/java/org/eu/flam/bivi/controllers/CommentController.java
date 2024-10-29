package org.eu.flam.bivi.controllers;

import java.security.Principal;

import org.eu.flam.bivi.models.Book;
import org.eu.flam.bivi.models.Comment;
import org.eu.flam.bivi.models.User;
import org.eu.flam.bivi.services.BookService;
import org.eu.flam.bivi.services.CommentService;
import org.eu.flam.bivi.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comments")
public class CommentController {

	private final CommentService commentService;
	private final BookService bookService;
	private final UserService userService;

	public CommentController(CommentService commentService, BookService bookService, UserService userService) {
		this.commentService = commentService;
		this.bookService = bookService;
		this.userService = userService;
	}

	@PostMapping("/{bookId}/new")
	public String saveComment(
		@PathVariable("bookId") Long bookId,
		@ModelAttribute("comment") Comment comment,
		Principal principal
	) {
		Book book = bookService.findById(bookId);
		User user = userService.findByEmail(principal.getName());
		commentService.saveComment(comment, book, user);

		return "redirect:/books/" + book.getId();
	}

}