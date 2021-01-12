package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Personne;

@Controller
public class HelloController {

    @RequestMapping("/home")
    public String home(@RequestParam(name = "prenom", required = false, defaultValue = "world") String prenom,
	    @RequestParam(name = "age", required = false, defaultValue = "0") int age, Model model) {

	Personne p = new Personne();
	p.setPrenom(prenom);
	p.setAge(age);
	model.addAttribute("personne", p);
	return "home";
    }

    @RequestMapping("/testModelAttribute")
    public String home(@ModelAttribute Personne personne, Model model) {
	model.addAttribute("personne", personne);
	return "home";
    }
}
