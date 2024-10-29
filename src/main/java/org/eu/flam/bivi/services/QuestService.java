package org.eu.flam.bivi.services;

import org.springframework.stereotype.Service;

import org.eu.flam.bivi.models.Book;
import org.eu.flam.bivi.models.Quest;
import org.eu.flam.bivi.repositories.QuestRepository;

@Service
public class QuestService extends BaseService<Quest> {

	private final QuestRepository repository;

	public QuestService(QuestRepository repository) {
		super(repository);
		this.repository = repository;
	}

	public void saveQuest( Quest quest, Book book) {
		quest.setBook(book);
		repository.save(quest);
	}
	
}
