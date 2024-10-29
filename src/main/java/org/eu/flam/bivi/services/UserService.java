package org.eu.flam.bivi.services;

import org.eu.flam.bivi.models.User;
import org.eu.flam.bivi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User> {

	private final UserRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserService(UserRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public User save(User user) {
		encryptUserPassword(user);
		return super.save(user);
	}

	private void encryptUserPassword(User user) {
		String hashedPassword = passwordEncoder.encode(user.getPassword());

		user.setPassword(hashedPassword);
	}

	public User findByEmail(String email) {
		return repository.findByEmail(email);
	}

	public boolean emailExists(String email) {
		return repository.existsByEmail(email);
	}

	public long getTotalUsers() {
		return repository.count();
	}

}