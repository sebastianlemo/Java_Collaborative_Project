package org.eu.flam.bivi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import org.eu.flam.bivi.models.Book;
import org.eu.flam.bivi.models.Quest;
import org.eu.flam.bivi.services.BookService;
import org.eu.flam.bivi.services.QuestService;

@Controller
@RequestMapping("/quests")
public class QuestController {

	@Autowired
	private QuestService questService;
	@Autowired
	private BookService bookService;

	@GetMapping("/{bookId}/new")
	public String newQuest(
		@PathVariable("bookId") Long bookId,
		@ModelAttribute("quest") Quest quest,
		Model model
	) {
		Book book = bookService.findById(bookId);
		model.addAttribute("book", book);
		return "quest.jsp";
	}

	@PostMapping("/{bookId}/new")
	public String saveQuest(
		@PathVariable("bookId") Long bookId,
		@Valid @ModelAttribute("quest") Quest quest,
		BindingResult result,
		Model model
	) {
		Book book = bookService.findById(bookId);
		if (result.hasErrors()) {
			model.addAttribute("book", book);
			return "quest.jsp";
		} else {
			questService.saveQuest(quest, book);
			return "redirect:/answers/" + quest.getId() + "/new";
		}
	}
}
