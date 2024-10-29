package org.eu.flam.bivi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.lang.NonNull;

@NoRepositoryBean
public interface BaseRepository<T> extends CrudRepository<T, Long> {

	@Override
	@NonNull
	List<T> findAll();

}