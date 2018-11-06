package ar.com.proyectoPecos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.com.proyectoPecos.model.Colaborador;
import ar.com.proyectoPecos.service.impl.ColaboradorService;

@Controller
public class MainController {
	
	@Autowired
	private ColaboradorService colaboradorService;

	@RequestMapping("/home")
    public String home() {
		Colaborador colaborador = new Colaborador();
		colaborador.setEmail("anacnazzo@gmail.com");
		colaborador.setPassword("ana123");
		colaboradorService.save(colaborador);
        return "home";
    }
	
	@RequestMapping("/")
    public String main() {
		Colaborador colaborador = new Colaborador();
		colaborador.setEmail("anacnazzo@gmail.com");
		colaborador.setPassword("ana123");
		colaboradorService.save(colaborador);
        return "home";
    }
	
}
