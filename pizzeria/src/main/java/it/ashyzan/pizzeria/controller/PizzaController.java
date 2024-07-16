package it.ashyzan.pizzeria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.ashyzan.pizzeria.model.PizzaModel;
import it.ashyzan.pizzeria.repository.PizzaRepository;
import jakarta.validation.Valid;

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

	@GetMapping("/ingredienti/{id}")
	public String dettagioPizza(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("ingredienti", repository.getReferenceById(id));
		return "/pizzeria/ingredienti";
	}

	// inserimento nuova pizza

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("pizza", new PizzaModel());
		return "/pizzeria/create";
	}

	@PostMapping("/create")
	public String salvaPizza(@Valid @ModelAttribute("pizza") PizzaModel pizza, BindingResult bindingresult, Model model)
//			, 		@RequestParam("image") MultipartFile file) throws IOException 
	{

//		// CARICAMENTO FILE
//		StringBuilder fileNames = new StringBuilder();
//		Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
//		fileNames.append(file.getOriginalFilename());
//		Files.write(fileNameAndPath, file.getBytes());
//		model.addAttribute("msg", "Uploaded images: " + fileNames.toString());

		// CONTROLLO PREZZO

		if (pizza.getPrezzo() <= 0) {

			bindingresult.addError(new ObjectError("Errore di prezzo", "Il prezzo della pizza è obbligatorio"));

		}

		if (bindingresult.hasErrors()) {
			return "/pizzeria/create";
		}
		repository.save(pizza);

		return "redirect:/pizzeria/index";
	}

	// modifica delle pizze già inserite

	@GetMapping("/edit/{id}")
	public String modificaPizza(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("pizza", repository.getReferenceById(id));
		return "/pizzeria/edit";
	}

	@PostMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute("pizza") PizzaModel pizza, BindingResult bindingresult, Model model) {

		if (pizza.getPrezzo() <= 0) {

			bindingresult.addError(new ObjectError("Errore di prezzo", "Il prezzo della pizza è obbligatorio"));

		}

		if (bindingresult.hasErrors()) {
			return "/pizzeria/edit";
		}
		repository.save(pizza);

		return "redirect:/pizzeria/index";
	}

	// delete pizza
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {

		repository.deleteById(id);

		return "redirect:/pizzeria/index";
	}

	// upload image files
	// public static String UPLOAD_DIRECTORY = System.getProperty("/img");
}
