package it.corso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/biografia")
public class BiografiaController {
	
	@GetMapping
	public String getPage(
			Model model,
			HttpSession session) 
	{
		boolean logged = false;
		if (session.getAttribute("utente") != null)
			logged = true;
		model.addAttribute("logged", logged);
		return"biografia";
	}

}
