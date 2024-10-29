package org.eu.flam.bivi.controllers;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
import org.eu.flam.bivi.models.User;
import org.eu.flam.bivi.services.UserService;
import org.eu.flam.bivi.validators.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

	private final UserService userService;
	private final UserValidator userValidator;

	public UserController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}

	@InitBinder
	private void InitBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(userValidator);
	}

	@GetMapping("/new")
	public String newUser(
		@RequestParam(value = "success", required = false) String success,
		@ModelAttribute("user") User user,
		Model model
	) {
		if (success != null) {
			model.addAttribute("successMessage", "Se registró con éxito");
		}
		return "register.jsp";
	}

	@PostMapping("/new")
	public String saveUser(
		@Valid @ModelAttribute("user") User user,
		BindingResult result,
		HttpSession session
	) {
		if (result.hasErrors()) {
			return "register.jsp";
		}

		userService.save(user);

		// UserDetails userDetails = securityUserDetails.loadUserByUsername(user.getEmail());
		// List<GrantedAuthority> authorities = new ArrayList<>(userDetails.getAuthorities());
		// Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, authorities);
		// SecurityContextHolder.getContext().setAuthentication(authentication);

		return "redirect:/users/new?success";
	}

	@GetMapping("/{userId}")
	public String userDetails(
		@PathVariable("userId") Long userId,
		Model model
	) {
		User user = userService.findById(userId);
		model.addAttribute("user", user);
		return "userProfile.jsp";
	}
}