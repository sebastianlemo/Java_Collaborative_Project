package org.eu.flam.bivi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "success", required = false) String success,
		Model model
	) {

		if (error != null) {
			model.addAttribute("errorMessage", "Correo o contraseña no válidos");
		}

		if (success != null) {
			model.addAttribute("successMessage", "Se inició sesión con éxito");
		}

		return "login.jsp";
	}

}