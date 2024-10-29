package org.eu.flam.bivi.validators;

import java.util.HashSet;
import java.util.Set;

import org.eu.flam.bivi.models.Role;
import org.eu.flam.bivi.models.User;
import org.eu.flam.bivi.services.RoleService;
import org.eu.flam.bivi.services.UserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

	private final UserService userService;
	private final RoleService roleService;

	public UserValidator(UserService userService, RoleService roleService) {
		this.userService = userService;
		this.roleService = roleService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;

		assignUserRoles(user);

		if (passwordsMismatch(user)) {
			errors.rejectValue("passwordConfirmation", "USER_PASSWORDS_MISMATCH");
		}

		if (userService.emailExists(user.getEmail())) {
			errors.rejectValue("email", "USER_EMAIL_ALREADY_REGISTERED");
		}

		if (user.getRoles().isEmpty()) {
			errors.rejectValue("email", "USER_ROLE_MISSING");
		}

		if (passwordNotContainAtLeastOneCharacter(user)) {
			errors.rejectValue("password", "USER_PASSWORD_MISSING_SPECIAL_CHARACTER");
		}
	}

	private void assignUserRoles(User user) {
		Set<Role> userRoles = new HashSet<>();
		Role role;
		long totalUsers = userService.getTotalUsers();

		if (totalUsers == 0) {
			role = roleService.findByName("ROLE_USER");
			userRoles.add(role);

			role = roleService.findByName("ROLE_ADMIN");
			userRoles.add(role);

			role = roleService.findByName("ROLE_PREMIUM");
			userRoles.add(role);
		} else if (totalUsers == 1) {
			role = roleService.findByName("ROLE_ADMIN");
			userRoles.add(role);
		} else {
			role = roleService.findByName("ROLE_USER");
			userRoles.add(role);
		}

		user.setRoles(userRoles);
	}

	private boolean passwordNotContainAtLeastOneCharacter(User user) {
		return !user.getPassword().matches(".*[!@#$%^&*()<>?].*");
	}

	public boolean passwordsMismatch(User user) {
		return user.getPassword().equals(user.getPasswordConfirmation()) == false;
	}
}