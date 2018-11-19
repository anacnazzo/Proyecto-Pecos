package ar.com.proyectoPecos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.proyectoPecos.model.Usuario;
import ar.com.proyectoPecos.service.IUsuarioService;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/public/users")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
public class UsuarioController {

	@Autowired
	IUsuarioService usuarioService;
	
	@PostMapping("/register")
	String register(@RequestParam("username") final String username, @RequestParam("password") final String password) {
		usuarioService.save(new Usuario(username,password));

		return login(username, password);
	}

	@PostMapping("/login")
	String login(@RequestParam("username") final String username, @RequestParam("password") final String password) {
		return usuarioService.login(username, password)
				.orElseThrow(() -> new RuntimeException("invalid login and/or password"));
	}

}
