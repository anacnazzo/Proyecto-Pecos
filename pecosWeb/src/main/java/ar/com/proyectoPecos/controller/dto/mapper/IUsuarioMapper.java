package ar.com.proyectoPecos.controller.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import ar.com.proyectoPecos.controller.dto.UsuarioDTO;
import ar.com.proyectoPecos.model.Usuario;

@Mapper
public interface IUsuarioMapper {

	UsuarioDTO toUsuarioDTO(Usuario usuario);

	List<UsuarioDTO> toUsuarioDTOs(List<Usuario> usuarios);

	Usuario toUsuario(UsuarioDTO usuarioDTO);

}
