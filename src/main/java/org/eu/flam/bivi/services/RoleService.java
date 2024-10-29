package org.eu.flam.bivi.services;

import org.eu.flam.bivi.models.Role;
import org.eu.flam.bivi.repositories.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService  {

	private final RoleRepository repository;

	public RoleService(RoleRepository repository) {
		this.repository = repository;

		try {
			Role role = new Role();
			role.setName("ROLE_USER");
			repository.save(role);

			role = new Role();
			role.setName("ROLE_ADMIN");
			repository.save(role);

			role = new Role();
			role.setName("ROLE_PREMIUM");
			repository.save(role);
		} catch (Exception e) {}
	}

	public Role findByName(String roleName) {
		return repository.findByName(roleName);
	}
}