package it.ashyzan.pizzeria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.ashyzan.pizzeria.model.PizzaModel;
import it.ashyzan.pizzeria.repository.PizzaRepository;

@Controller
@RequestMapping("/pizzeria")
public class PizzaController {

	// l'annotazione autowired serve a spring per dirgli di gestire autonomamente
	// tramite la dependency injection e inversion of control
	// inietta nel repository la new a runtime
	@Autowired
	private PizzaRepository repository;

	@GetMapping("index")
	public String index(Model model) {
		List<PizzaModel> pizze = repository.findAll();
		model.addAttribute("pizze", pizze);

		return "/pizzeria/index";
	}

}
