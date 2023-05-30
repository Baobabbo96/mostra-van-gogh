package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Opera;
import it.corso.model.Ordine;
import it.corso.model.Utente;
import it.corso.service.OperaService;
import it.corso.service.OrdineService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/ordine")
public class OrdineController 
{
	@Autowired
	private OperaService OperaService;

	@Autowired
	private OrdineService ordineService;

	@GetMapping
	public String getPage(Model model,
			HttpSession session) 
	{
		if(session.getAttribute("utente") != null) 
		{
			boolean logged = false;
			
			if(session.getAttribute("utente") != null) {
				logged = true;
			}
			List<Opera> opere = OperaService.getOpere();
			model.addAttribute("opere", opere);
			model.addAttribute("logged", logged);
			return "ordine";
		}
		return"redirect:/forbidden";
	}
	
	@PostMapping
	public String registraOrdine(Model model,
			HttpSession session,
			@RequestParam(name = "opere", required = false) int[] idOpere) 
	{
		if (idOpere == null) {
			return "redirect:/ordine";
		}
		Ordine ordine = new Ordine();
		Utente utente = (Utente) session.getAttribute("utente");
		int idUtente = utente.getId();
		ordineService.registraOrdine(ordine, idUtente, idOpere);
		return "redirect:/home";
	}
}
