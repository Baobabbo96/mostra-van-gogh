package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.service.BigliettoService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("listabiglietti")
public class ListaBigliettiController 
{
	@Autowired
	private BigliettoService bigliettoService;
	
	@GetMapping
	public String getPage(Model model,HttpSession session) 
	{
		if (session.getAttribute("admin") != null) {
			model.addAttribute("biglietti", bigliettoService.getBiglietto());
			return "lista_biglietti";
		}
		return "redirect:/forbidden";
	}
}
