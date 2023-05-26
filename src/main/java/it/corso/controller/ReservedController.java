package it.corso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/reserved")
public class ReservedController {

	@GetMapping
	public String getPage(HttpSession session) {
		if(session.getAttribute("utente") == null)
			return "redirect:/forbidden";
		return "reserved";
	}
}
