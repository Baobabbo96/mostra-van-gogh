package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.service.OperaService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/opereadmin")
public class ListaOpereAdminController {

	@Autowired
	private OperaService operaService;
	
	@GetMapping
	public String getPage(
			Model model,
			HttpSession session) {
		if (session.getAttribute("admin") == null)
			return "redirect:/home";
		model.addAttribute("opere", operaService.getOpere());
		return "lista_opere_admin";
	}
	
	@GetMapping("/cancella")
	public String cancellaOpera(@RequestParam("id") int id, 
			HttpSession session) {
		if(session.getAttribute("admin") != null ) {
			operaService.cancellaOpera(operaService.getOperaById(id));
			return "redirect:/opereadmin";
		}
		return "redirect:/home";
	}
}
