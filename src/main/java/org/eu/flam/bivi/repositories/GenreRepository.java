package org.eu.flam.bivi.repositories;

import org.eu.flam.bivi.models.Genre;

public interface GenreRepository extends BaseRepository<Genre> {

	Genre findByDescription(String description);

}