package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.dao.OperaDao;

@Controller
@RequestMapping("/edit")
public class OpereController {

	@Autowired
	private OperaDao operaDao;
	
	//@GetMapping
	//public String getPage()
}
