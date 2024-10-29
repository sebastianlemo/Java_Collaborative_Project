package org.eu.flam.bivi.repositories;

import org.eu.flam.bivi.models.User;

public interface UserRepository extends BaseRepository<User> {

	User findByEmail(String email);

	boolean existsByEmail(String email);

}