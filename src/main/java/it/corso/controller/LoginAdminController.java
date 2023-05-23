package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.service.AdminService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginAdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping
	public String getPage(
			Model model,
			HttpSession session) {
		return "login_admin";
	}
	
	@PostMapping("/login")
	public String gestioneLogin(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			HttpSession session) {
		if (adminService.controlloLogin(session, username, password))
			return "redirect:/reservedadmin";
		return "redirect:/admin";
	}
}
