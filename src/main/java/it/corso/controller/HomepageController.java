package it.corso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Controller
@RequestMapping("/home")
public class HomepageController {

	@GetMapping
	public String getPage(
			HttpSession session,
			Model model) {
		boolean logged = false;
		if (session.getAttribute("utente") != null)
			logged = true;
		model.addAttribute("logged", logged);
		return "home";
	}
}
