package org.eu.flam.bivi.services;

import org.springframework.stereotype.Service;

import org.eu.flam.bivi.models.Genre;
import org.eu.flam.bivi.repositories.GenreRepository;

@Service
public class GenreService extends BaseService<Genre> {

	private final GenreRepository repository;

	public GenreService(GenreRepository repository) {
		super(repository);
		this.repository = repository;
	}

	public Genre findByDescription(String description) {
		return repository.findByDescription(description);
	}

}
