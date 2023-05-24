package it.corso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/reservedadmin")
public class ReservedAdminController {
	
	@GetMapping
	public String getPage(HttpSession session) {
		if(session.getAttribute("admin") == null)
			return "redirect:/admin";
		return "reserved_admin";
	}
}