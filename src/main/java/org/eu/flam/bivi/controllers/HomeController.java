package org.eu.flam.bivi.controllers;

import java.util.Comparator;
import java.util.List;

import org.eu.flam.bivi.models.Book;
import org.eu.flam.bivi.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	private final BookService bookService;

	public HomeController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/")
	public String home(Model model) {

		model.addAttribute("recentBooks", bookService.findByCreatedAt());

		List<Book> booksTop = bookService.findAll();
		booksTop.sort(Comparator.comparingInt(book -> ((Book) book).getComments().size()).reversed());
		model.addAttribute("booksTop", booksTop);

		return "home.jsp";
	}

	@GetMapping("/help")
	public String help() {
		return "help.jsp";
	}

	@GetMapping("/privacy")
	public String privacy(){
		return "privacyPolicy.jsp";
	}

	@GetMapping("/about")
	public String about(){
		return "about.jsp";
	}
}