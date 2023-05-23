package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.service.OperaService;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import it.corso.model.Opera;


@Controller
@RequestMapping("/registraopere")
public class RegistraOpereController {

	@Autowired
	private OperaService operaService;
	
	@GetMapping
	public String getPage(
			Model model,
			HttpSession session){
		if (session.getAttribute("admin")==null) {
			return "redirect:/home";
		}
		
		model.addAttribute("opera", new Opera());
		return "regista_opere";
		
	}	
	
//	@PostMapping
//	public String registraOpera() {
//		
//	}
}
