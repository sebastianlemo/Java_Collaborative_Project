package org.eu.flam.bivi.controllers;

import org.eu.flam.bivi.models.Genre;
import org.eu.flam.bivi.services.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/genres")
public class GenreController {

	private final GenreService genreService;

	public GenreController(GenreService genreService) {
		this.genreService = genreService;
	}

	@GetMapping("/new")
	public String newGenre(@ModelAttribute("genre") Genre genre) {
		return "genre.jsp";
	}

	@PostMapping("/new")
	public String saveGenre(@Valid @ModelAttribute("genre") Genre genre, BindingResult result) {

		if (result.hasErrors()) {
			return "genre.jsp";
		}

		genreService.save(genre);
		return "redirect:/genres";
	}

	@GetMapping("")
	public String findAllGenres(Model model) {
		model.addAttribute("genres", genreService.findAll());
		return "genresAll.jsp";
	}
}