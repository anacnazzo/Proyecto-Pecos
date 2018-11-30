package ar.com.proyectoPecos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String listar(@RequestParam("pagina") Integer pagina, Model model) {
		model.addAttribute("usuarios", usuarioService.findAll(1, TAMANIO_PAGINA));

		// Paginado
		Integer cantidadRegistros = usuarioService.count();
		Integer resto = (cantidadRegistros % TAMANIO_PAGINA) == 0 ? 0 : 1;
		Integer paginas = new Integer(cantidadRegistros / TAMANIO_PAGINA + resto);
		model.addAttribute("PAGINA", PAGINA_1);
		model.addAttribute("PAGINAS", paginas);
		model.addAttribute("REFERENCIA_PAGINADO", "/usuarios");

		return "usuarios/listar";
	}

}
