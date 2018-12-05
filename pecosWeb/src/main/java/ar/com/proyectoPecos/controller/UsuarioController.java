package ar.com.proyectoPecos.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.com.proyectoPecos.model.Colaborador;
import ar.com.proyectoPecos.service.impl.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@Value("${pagination.max}")
	private Integer TAMANIO_PAGINA;

	@Value("${pagination.first}")
	private Integer PAGINA_1;

	@RequestMapping("/login")
	public String login() {
		return "usuarios/login";
	}

	@RequestMapping("/registro")
	public String registro() {
		return "usuarios/registro";
	}

	@RequestMapping("/usuarios")
	public String listar(@RequestParam(value = "pagina",  required=false) Integer pagina, Model model) {
		
		Colaborador colaborador = new Colaborador();
		colaborador.setEmail("anacnazzo@gmail.com");
		colaborador.setPassword("123456");
		colaborador.setValidezDesde(new Date());
		colaborador.setValidezHasta(new Date());
		usuarioService.save(colaborador);
		
		pagina = pagina==null?PAGINA_1:pagina;
		
		model.addAttribute("usuarios", usuarioService.findAll(pagina, TAMANIO_PAGINA));

		// Paginado
		Integer cantidadRegistros = usuarioService.count();
		Integer resto = (cantidadRegistros % TAMANIO_PAGINA) == 0 ? 0 : 1;
		Integer paginas = new Integer(cantidadRegistros / TAMANIO_PAGINA + resto);
		model.addAttribute("pagina", pagina);
		model.addAttribute("paginas", paginas);
		model.addAttribute("REFERENCIA_PAGINADO", "/usuarios");

		return "usuarios/listar";
	}

	@RequestMapping("/usuarios/editar")
	public String editar(@RequestParam("id") Integer id, Model model) {

		return "usuarios/editar";
	}
	
	@RequestMapping("/usuarios/eliminar")
	public String eliminar(@RequestParam("id") Integer id, Model model) {
		

		return "usuarios/eliminar";
	}
	
	@RequestMapping("/usuarios/limitar")
	public String limitar(@RequestParam("id") Integer id, Model model) {
		

		return "usuarios/limitar";
	}
	
	@RequestMapping("/usuarios/roles")
	public String roles(@RequestParam("id") Integer id, Model model) {
		

		return "usuarios/roles";
	}
}
