package ar.com.proyectoPecos.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ar.com.proyectoPecos.controller.dto.UsuarioDTO;
import ar.com.proyectoPecos.model.Actor;
import ar.com.proyectoPecos.model.Calle;
import ar.com.proyectoPecos.model.Colaborador;
import ar.com.proyectoPecos.model.Localidad;
import ar.com.proyectoPecos.model.Padrino;
import ar.com.proyectoPecos.model.Pais;
import ar.com.proyectoPecos.model.Provincia;
import ar.com.proyectoPecos.service.impl.CalleService;
import ar.com.proyectoPecos.service.impl.ColaboradorService;
import ar.com.proyectoPecos.service.impl.LocalidadService;
import ar.com.proyectoPecos.service.impl.PadrinoService;
import ar.com.proyectoPecos.service.impl.PaisService;
import ar.com.proyectoPecos.service.impl.ProfesionalService;
import ar.com.proyectoPecos.service.impl.ProvinciaService;
import ar.com.proyectoPecos.service.impl.TipoDNIService;
import ar.com.proyectoPecos.service.impl.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	ColaboradorService colaboradorService;

	@Autowired
	PadrinoService padrinoService;

	@Autowired
	ProfesionalService profesionalService;

	@Autowired
	TipoDNIService tipoDNIService;

	@Autowired
	PaisService paisService;

	@Autowired
	ProvinciaService provinciaService;

	@Autowired
	LocalidadService localidadService;

	@Autowired
	CalleService calleService;

	@Value("${pagination.max}")
	private Integer TAMANIO_PAGINA;

	@Value("${pagination.first}")
	private Integer PAGINA_1;

	@Value("${ubicacion.principal.pais}")
	private Integer PAIS;

	@Value("${ubicacion.principal.provincia}")
	private Integer PROVINCIA;

	@Value("${ubicacion.principal.localidad}")
	private Integer LOCALIDAD;

	@RequestMapping("/login")
	public String login() {
		return "usuarios/login";
	}

	@RequestMapping("/registro")
	public String registro() {
		return "usuarios/registro";
	}

	@RequestMapping("/usuarios")
	public String listar(@RequestParam(value = "pagina", required = false) Integer pagina, Model model) {

		pagina = paginado(model, pagina);
		model.addAttribute("usuarios", usuarioService.findAll(pagina, TAMANIO_PAGINA));

		return "usuarios/listar";
	}

	@RequestMapping("/usuarios/editar")
	public String editar(@RequestParam("id") Integer id, Model model) {

		UsuarioDTO usuario = this.getUsuarioDTO((Actor)usuarioService.findById(id));
		model.addAttribute("usuario", usuario);
		armarModelo(model, usuario);

		return "usuarios/perfil";
	}

	

	

	@RequestMapping("/usuarios/crear")
	public String crear(Model model) {

		UsuarioDTO usuario = new UsuarioDTO();
		model.addAttribute("usuario", usuario);
		armarModelo(model, usuario);

		return "usuarios/perfil";
	}

	@PostMapping("/usuarios/guardar")
	public String crear(@ModelAttribute UsuarioDTO usuario) {

		colaboradorService.save(this.getUsuario(usuario));

		return "usuarios/listar";
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

	private void armarModelo(Model model, UsuarioDTO usuario) {

		List<Pais> paises = paisService.findAll();
		Localidad localidad = new Localidad();
		Provincia provincia = new Provincia();
		Pais pais = new Pais();
	
		model.addAttribute("tiposDni", tipoDNIService.findAll());
		model.addAttribute("paises", paises);
		
		if (usuario.getIdLocalidad() != null) {
			localidad = localidadService.findById(usuario.getIdLocalidad());
			provincia = provinciaService.findById(usuario.getIdProvincia());
			pais = paisService.findById(usuario.getIdPais());
		} else {
			localidad = localidadService.findById(LOCALIDAD);
			provincia = provinciaService.findById(PROVINCIA);
			pais = paisService.findById(PAIS);
			
		}
		
		model.addAttribute("provincias", provinciaService.findByPais(pais));
		model.addAttribute("localidades", localidadService.findByProvincia(provincia));
		model.addAttribute("calles", calleService.findByLocalidad(localidad));
		model.addAttribute("paisSeleccionado", pais.getId());
		model.addAttribute("provinciaSeleccionada", provincia.getId());
		model.addAttribute("localidadSeleccionada", localidad.getId());
	
	}

	private Integer paginado(Model model, Integer pagina) {

		pagina = pagina == null ? PAGINA_1 : pagina;
		Integer cantidadRegistros = usuarioService.count();
		Integer resto = (cantidadRegistros % TAMANIO_PAGINA) == 0 ? 0 : 1;
		Integer paginas = new Integer(cantidadRegistros / TAMANIO_PAGINA + resto);
		model.addAttribute("pagina", pagina);
		model.addAttribute("paginas", paginas);
		model.addAttribute("REFERENCIA_PAGINADO", "/usuarios");
		return pagina;
	}

	/**
	 * Devuelve a la vista la lista de departamentos de la provincia seleccionada
	 * 
	 * @param model
	 * @return HttpServletResponse
	 * @throws IOException
	 */
	@RequestMapping(value = "/usuarios/cambiarProvinciaLocalidad", method = RequestMethod.GET)
	public HttpServletResponse cambiarProvinciaLocalidad(@RequestParam("select") String select,
			@RequestParam("opcion") Integer opcion, HttpServletResponse respuesta) throws IOException {

		PrintWriter out = respuesta.getWriter();
		respuesta.setHeader("Content-Type", "text/xml; charset=UTF-8");

		if (select.equals("provincias")) {
			Pais pais = paisService.findById(opcion);
			List<Provincia> provincias = provinciaService.findByPais(pais);

			try {
				for (Provincia provincia : provincias)
					out.printf("<option value='%1s'>%2s</option>", provincia.getId(), provincia.getNombre());
			} finally {
				out.close();
			}
		}
		else if (select.equals("localidades")) {
			Provincia provincia = provinciaService.findById(opcion);
			List<Localidad> localidades = localidadService.findByProvincia(provincia);

			try {
				for (Localidad localidad : localidades)
					out.printf("<option value='%1s'>%2s</option>", localidad.getId(), localidad.getNombre());
				
			} finally {
				out.close();
			}
		}
		else if (select.equals("calles")) {
			Localidad localidad = localidadService.findById(opcion);
			List<Calle> calles = calleService.findByLocalidad(localidad);

			try {
				for (Calle calle : calles)
					out.printf("<option value='%1s'>%2s</option>", calle.getId(), calle.getNombre());
			} finally {
				out.close();
			}
		}
		return respuesta;

	}
	
	
	private Colaborador getUsuario(UsuarioDTO actor) {
		
		Calle calle = calleService.findById(actor.getIdCalle());
		Colaborador usuario = new Colaborador();
/*		usuarioactor.getId(), actor.getEmail(), actor.getPassword(),
				actor.getApellido(), actor.getNombre(), actor.getIdDni(), actor.getDni(),
				actor.getCalle(), actor.getNumeroCalle(),
				actor.getPiso(), actor.getDepto(), 
				actor.getIdLocalidad(),
				actor.getIdProvincia(), 
				actor.getIdPais(),
				actor.getTelefonoFijo(), actor.getTelefonoMovil());*/
		return usuario;
	}

	private UsuarioDTO getUsuarioDTO(Actor actor) {
		UsuarioDTO usuario = new UsuarioDTO(actor.getId(), actor.getEmail(), actor.getPassword(),
				actor.getApellido(), actor.getNombre(), actor.getTipoDni().getId(), actor.getDni(),
				actor.getDireccion().getCalle().getId(),
				actor.getDireccion().getCalle().getNombre(), actor.getDireccion().getNumeroCalle(),
				actor.getDireccion().getPiso(), actor.getDireccion().getDepto(), 
				actor.getDireccion().getCalle().getLocalidad().getId(),
				actor.getDireccion().getCalle().getLocalidad().getProvincia().getId(), 
				actor.getDireccion().getCalle().getLocalidad().getProvincia().getPais().getId(),
				actor.getTelefonoFijo(), actor.getTelefonoMovil());
		return usuario;
	}
	
}
