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
	public String getPage(Model model, 
			HttpSession session,
			@RequestParam(name="derr", required = false) String derr,
			@RequestParam(name="berr", required = false) String berr) 
	{	
		boolean logged = false;
		if  (session.getAttribute("utente") != null) 
		{
			logged = true;
			List<Evento> eventi= eventoService.getEventi();
			model.addAttribute("dataError", derr != null);
			model.addAttribute("bigliettoError", berr != null);
			model.addAttribute("eventi", eventi);
			model.addAttribute("logged", logged);
			return "biglietto";
		}
		return "redirect:/forbidden";
	}
	
	@PostMapping
	public String compraBiglietto(
			@RequestParam("dataIngresso") String dataIngresso,
			@RequestParam("idEvento") int idEvento,
			HttpSession session)
	{
		Utente utente= (Utente) session.getAttribute("utente");
		int idUtente= utente.getId();
		if (bigliettoService.registraBiglietto(dataIngresso,idUtente,idEvento).equalsIgnoreCase("save")) 
		{
			return"redirect:/home";
		}else if (bigliettoService.registraBiglietto(dataIngresso,idUtente,idEvento).equalsIgnoreCase("data")) {
			return"redirect:/biglietto?derr";
		}
		return "redirect:/biglietto?berr";
		
	}
}
