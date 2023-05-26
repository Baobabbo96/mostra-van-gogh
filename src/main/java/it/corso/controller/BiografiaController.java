package it.corso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/biografia")
public class BiografiaController {
	
	@GetMapping
	public String getPage() 
	{
		return"biografia";
	}

}
