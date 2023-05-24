package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.model.Utente;
import it.corso.service.UtenteService;

@Controller
@RequestMapping("/registrazione")
public class RegistraUtenteController {

	@Autowired
	private UtenteService utenteService;
	
	@PostMapping
	public String registrazione(@ModelAttribute("utente") Utente utente) {
		utenteService.registraUtente(utente);
		return "redirect:/home";
	}
	
	@GetMapping
	public String getPage(Model model) {
		Utente utente = new Utente();
		model.addAttribute("utente", utente);
		return "registrazione";
	}
	

}
