package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import it.corso.service.OperaService;
import jakarta.servlet.http.HttpSession;
import it.corso.model.Opera;


@Controller
@RequestMapping("/registraopere")
public class RegistraOpereController {

	@Autowired
	private OperaService operaService;
	
	private Opera opera;
	
	@GetMapping
	public String getPage(
			Model model,
			HttpSession session,
			@RequestParam(name="id", required = false) Integer id)
	{
		if (session.getAttribute("admin")==null) {
			return "redirect:/forbidden";
		}
		opera = id == null ? new Opera() : operaService.getOperaById(id);
		model.addAttribute("opera", opera);
		return "inserimento_opere";		
	}	
	
	@PostMapping
	public String registraOpera
		(
			@RequestParam("titolo") String titolo,
			@RequestParam("descrizione") String descrizione,
			@RequestParam(name = "immagine", required = false) MultipartFile immagine,
			@RequestParam("tecnica") String tecnica,
			@RequestParam("prezzoStampa") double prezzoStampa,
			@RequestParam("anno") String anno
		) 
	{
		operaService.registraOpera(opera,titolo,descrizione,immagine,
								   tecnica,prezzoStampa,anno);
		return "redirect:/opereadmin";
		
	}
}
