package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Evento;
import it.corso.model.Utente;
import it.corso.service.BigliettoService;
import it.corso.service.EventoService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/biglietto")
public class BigliettoController {
	
	@Autowired
	private BigliettoService bigliettoService;
	
	@Autowired
	private EventoService eventoService;
	
	
	@GetMapping
	public String getPage(Model model) 
	{	
		List<Evento> eventi= eventoService.getEventi();
		model.addAttribute("eventi", eventi);
		
		return "biglietto";
	}
	
	@PostMapping
	public String compraBiglietto(
			@RequestParam("dataIngresso") String dataIngresso,
			@RequestParam("idEvento") int idEvento,
			HttpSession session)
	{
		Utente utente= (Utente) session.getAttribute("utente");
		int idUtente= utente.getId();
		bigliettoService.registraBiglietto(dataIngresso,idUtente,idEvento);
		return"redirect:/home";
	}
}
