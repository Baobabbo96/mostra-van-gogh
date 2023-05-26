package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.service.UtenteService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/list")
public class ListaUtenteController {

	@Autowired
	private UtenteService utenteService;
	
	@GetMapping
	public String getPage(Model model,HttpSession session) 
	{
		if (session.getAttribute("admin") != null) 
		{
			model.addAttribute("utenti", utenteService.getUtenti());
			return "index";
		}
		return "redirect:/forbidden";
	}
}
