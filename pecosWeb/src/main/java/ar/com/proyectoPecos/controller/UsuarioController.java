package ar.com.proyectoPecos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import ar.com.proyectoPecos.model.Colaborador;
import ar.com.proyectoPecos.service.impl.ColaboradorService;

@Controller

public class UsuarioController {
	

	@Autowired
	private ColaboradorService colaboradorService;


	@RequestMapping(value = "/saveColaborador", method = RequestMethod.POST)
	public String create(@ModelAttribute("colaborador") Colaborador colaborador, BindingResult result, SessionStatus status, Model model) {

		colaboradorService.save(colaborador);
		status.setComplete();

		return "redirect:home";
	}
	
	@RequestMapping("/login")
	public String login() {

		

		return "login";
	}
	
	
}
