package org.eu.flam.bivi.repositories;

import org.eu.flam.bivi.models.Role;

public interface RoleRepository extends BaseRepository<Role> {

	Role findByName(String roleName);

}