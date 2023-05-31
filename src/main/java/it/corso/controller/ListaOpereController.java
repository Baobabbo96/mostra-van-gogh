package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.service.OperaService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/opere")
public class ListaOpereController {

	@Autowired
	private OperaService operaService;
	
	@GetMapping
	public String getPage(
			HttpSession session, 
			Model model) {
		boolean logged = false;
		if (session.getAttribute("utente") != null)
			logged = true;
		model.addAttribute("logged", logged);
		model.addAttribute("opere",operaService.getOpere());
		return "lista_opere";
	
	}
	
}
