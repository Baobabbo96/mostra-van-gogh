package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.service.OrdineService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/listaordini")
public class ListaOrdiniController {

	@Autowired
	private OrdineService ordineService;
	
	@GetMapping
	public String getPage(
			Model model,
			HttpSession session) {
		if (session.getAttribute("admin") == null)
			return "redirect:/home";
		model.addAttribute("ordini", ordineService.getOrdini());
		return "lista_ordini";
	}
}
