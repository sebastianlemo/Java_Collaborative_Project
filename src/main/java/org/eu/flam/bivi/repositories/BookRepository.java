package org.eu.flam.bivi.repositories;

import java.util.List;

import org.eu.flam.bivi.models.Book;

public interface BookRepository extends BaseRepository<Book> {

	List<Book> findTop3ByOrderByCreatedAtDesc();
	List<Book> findByTitleContaining(String title);

}