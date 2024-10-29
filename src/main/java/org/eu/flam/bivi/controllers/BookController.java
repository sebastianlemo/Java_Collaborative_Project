package org.eu.flam.bivi.controllers;

import java.security.Principal;

import org.eu.flam.bivi.models.Book;
import org.eu.flam.bivi.models.Comment;
import org.eu.flam.bivi.models.User;
import org.eu.flam.bivi.services.BookService;
import org.eu.flam.bivi.services.GenreService;
import org.eu.flam.bivi.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {

	private final BookService bookService;
	private final UserService userService;
	private final GenreService genreService;

	public BookController(BookService bookService, UserService userService, GenreService genreService) {
		this.bookService = bookService;
		this.userService = userService;
		this.genreService = genreService;
	}

	@GetMapping("/new")
	public String newBook(
		@ModelAttribute("book") Book book,
		Model model
	) {
		model.addAttribute("genres", genreService.findAll());
		return "book.jsp";
	}

	@PostMapping("/new")
	public String saveBook(
		@Valid @ModelAttribute("book") Book book,
		BindingResult result,
		Principal principal,
		Model model
	) {
		if (result.hasErrors()) {
			model.addAttribute("genres", genreService.findAll());
			return "book.jsp";
		}
		User user = userService.findByEmail(principal.getName());
		bookService.saveBook(book, user);

		return "redirect:/books/" + book.getId();
	}

	@GetMapping("/{bookId}")
	public String showBook(
		@PathVariable("bookId") Long bookId,
		@ModelAttribute("comment") Comment comment,
		Model model
	) {
		Book book = bookService.findById(bookId);
		model.addAttribute("book", book);
		return "bookDetails.jsp";
	}

}