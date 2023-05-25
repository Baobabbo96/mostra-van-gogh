package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.service.UtenteService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UtenteService utenteService;

	@GetMapping
	public String getPage(
			Model model,
			HttpSession session,
			@RequestParam(name = "le", required = false) String logError) {
		model.addAttribute("logError", logError != null);
		return "login";
	}
	
	@PostMapping("/check")
	public String gestioneLogin(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			HttpSession session) {
		if (utenteService.controlloLogin(session, username, password))
			return "redirect:/reserved";
		return "redirect:/login?le";
	}
}
