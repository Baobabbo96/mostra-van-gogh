package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.model.Biglietto;
import it.corso.model.Opera;
import it.corso.model.Ordine;
import it.corso.model.Utente;
import it.corso.service.BigliettoService;
import it.corso.service.OperaService;
import it.corso.service.OrdineService;
import it.corso.service.UtenteService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/reservedadmin")
public class ReservedAdminController {
	
	@Autowired
	private UtenteService utenteService;
	
	@Autowired
	private OrdineService ordineService;
	
	@Autowired
	private BigliettoService bigliettoService;
	
	@Autowired
	private OperaService operaService;
	
	@GetMapping
	public String getPage(
			HttpSession session,
			Model model) {
		if(session.getAttribute("admin") == null)
			return "redirect:/forbidden";
		List<Utente> utenti = utenteService.getLastUtenti();
		List<Ordine> ordini = ordineService.getLastOrdini();
		List<Opera> opere = operaService.getLastOpera();
		List<Biglietto> biglietti = bigliettoService.getLastBiglietto();
		model.addAttribute("utenti", utenti);
		model.addAttribute("ordini", ordini);
		model.addAttribute("biglietti", biglietti);
		model.addAttribute("opere", opere);
		return "reserved_admin";
	}
	
}
