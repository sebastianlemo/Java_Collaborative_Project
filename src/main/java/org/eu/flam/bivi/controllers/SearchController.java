package org.eu.flam.bivi.controllers;

import org.eu.flam.bivi.models.Genre;
import org.eu.flam.bivi.services.BookService;
import org.eu.flam.bivi.services.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/search")
public class SearchController {

	private final BookService bookService;
	private final GenreService genreService;

	public SearchController(BookService bookService, GenreService genreService) {
		this.bookService = bookService;
		this.genreService = genreService;
	}

	@GetMapping("")
	public String search(
		@RequestParam(value = "title", required = false) String title,
		@RequestParam(value = "genre", required = false) String genre,
		Model model
	) {

		model.addAttribute("genres", genreService.findAll());

		if (title == null && genre == null) {
			model.addAttribute("books", bookService.findAll());
		}
		if (title != null) {
			model.addAttribute("books", bookService.findByTitle(title));
		}

		if (genre != null) {
			Genre genreBooks = genreService.findByDescription(genre);
			model.addAttribute("books", genreBooks.getBooks());
		}

		return "explore.jsp";
	}

	@GetMapping("/{genre}")
	public String searchGenre(
		@PathVariable("genre") String genre
	) {
		return "redirect:/search?genre=" + genre;
	}

	@PostMapping("")
	public String searchTitle(
		@RequestParam("title") String title
	) {
		return "redirect:/search?title=" + title;
	}
}