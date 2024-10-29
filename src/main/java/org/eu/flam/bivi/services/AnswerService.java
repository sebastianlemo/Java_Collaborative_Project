package org.eu.flam.bivi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import org.eu.flam.bivi.models.Answer;
import org.eu.flam.bivi.models.Quest;
import org.eu.flam.bivi.repositories.AnswerRepository;

@Service
public class AnswerService extends BaseService<Answer> {

	private final AnswerRepository repository;

	public AnswerService(AnswerRepository repository) {
		super(repository);
		this.repository = repository;
	}

	public void saveAnswers(List<String> answers, Quest quest) {
		for (String text : answers) {
			Answer answer = new Answer();
			answer.setText(text);
			answer.setQuest(quest);
			repository.save(answer);
		}
	}

	public void isCorrect(Long answerId) {
		Answer answer = findById(answerId);
		answer.setIsCorrect(true);
		repository.save(answer);
	}
}