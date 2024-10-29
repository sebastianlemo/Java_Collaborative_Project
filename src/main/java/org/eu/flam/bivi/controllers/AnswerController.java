package org.eu.flam.bivi.controllers;

import java.util.List;

import org.eu.flam.bivi.models.Quest;
import org.eu.flam.bivi.services.AnswerService;
import org.eu.flam.bivi.services.QuestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/answers")
public class AnswerController {

	private final QuestService questService;
	private final AnswerService answerService;

	public AnswerController(QuestService questService, AnswerService answerService) {
		this.questService = questService;
		this.answerService = answerService;
	}

	@GetMapping("{questId}/new")
	public String newAnswer(
		@PathVariable("questId") Long questId,
		Model model
	) {
		Quest quest = questService.findById(questId);
		model.addAttribute("quest", quest);
		return "answer.jsp";
	}

	@PostMapping("{questId}/new")
	public String saveAnswer(
		@PathVariable("questId") Long questId,
		@RequestParam("answers") List<String> answers
	) {
		Quest quest = questService.findById(questId);
		answerService.saveAnswers(answers, quest);
		return "redirect:/answers/{questId}/correct";
	}

	@GetMapping("/{questId}/correct")
	public String selectAnswer(
		@PathVariable("questId") Long questId,
		Model model
	) {
		Quest quest = questService.findById(questId);
		model.addAttribute("quest", quest);
		return "answerCorrect.jsp";
	}

	@PostMapping("/{questId}/correct")
	public String correctAnswer(
		@PathVariable("questId") Long questId,
		@RequestParam("answerId") Long answerId
	) {
		Quest quest = questService.findById(questId);
		answerService.isCorrect(answerId);
		System.out.println(answerId);
		return "redirect:/books/" +  quest.getBook().getId();
	}
}