package it.ashyzan.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.ashyzan.pizzeria.repository.PizzaRepository;

@Controller
@RequestMapping("/pizzeria")
public class PizzaController {
	
	@Autowired
	private PizzaRepository pizzaRepo;
	
	@GetMapping("/index")
	public String pizze(Model model) {
		
		model.addAttribute("pizze", pizzaRepo.findAll());
		
		return "/pizzeria/index";
	}

}
