package org.eu.flam.bivi.services;

import java.util.List;
import java.util.Optional;

import org.eu.flam.bivi.repositories.BaseRepository;

public abstract class BaseService<T> {

	private final BaseRepository<T> repository;

	public BaseService(BaseRepository<T> repository) {
		this.repository = repository;
	}

	public List<T> findAll() {
		return repository.findAll();
	}

	public T findById(Long id) {
		Optional<T> optional = repository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	public T save(T entity) {
		return repository.save(entity);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}