package it.corso.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import it.corso.model.Biglietto;
import it.corso.model.Ordine;
import it.corso.model.Utente;
import it.corso.service.BigliettoService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/reserved")
public class ReservedController {
	
	@Autowired
	BigliettoService bigliettoService;

	@GetMapping
	public String getPage(HttpSession session,
			Model model) {
		
		boolean logged = false;
		if(session.getAttribute("utente") != null) 
		{
			logged = true;
			Utente utente = (Utente) session.getAttribute("utente");
			List<Biglietto> biglietti = bigliettoService.getBigliettobyUtente(utente);
			List<Ordine> ordini = utente.getOrdini();
			model.addAttribute("logged", logged);
			model.addAttribute("utente", utente);
			model.addAttribute("ordini", ordini);
			model.addAttribute("biglietti", biglietti);
			return "reserved";
		}
		return "redirect:/login";
	}
}
