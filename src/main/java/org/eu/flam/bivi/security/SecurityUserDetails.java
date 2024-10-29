package org.eu.flam.bivi.security;

import java.util.ArrayList;
import java.util.List;

import org.eu.flam.bivi.models.Role;
import org.eu.flam.bivi.models.User;
import org.eu.flam.bivi.services.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetails implements UserDetailsService {

	private final UserService userService;

	public SecurityUserDetails(UserService userService) {
		this.userService = userService;
	}

	// Debido a que no usamos Username sino Email, debemos buscar por Email.
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User userEntity = userService.findByEmail(email);

		if (userEntity == null) {
			throw new UsernameNotFoundException("User not found");
		}

		org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(
			userEntity.getEmail(),
			userEntity.getPassword(),
			getAuthorities(userEntity));

			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
			userDetails,
			userEntity.getPassword(),
			userDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(auth);

		return userDetails;
	}

	private List<GrantedAuthority> getAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(Role role : user.getRoles()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
			authorities.add(grantedAuthority);
		}

		return authorities;
	}

}