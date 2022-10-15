package com.qpets.qpetsproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qpets.qpetsproject.model.ChangePassword;
import com.qpets.qpetsproject.model.Usuario;
import com.qpets.qpetsproject.service.UsuarioService;

@RestController
@RequestMapping(path="/api/usuario/")
public class UsuarioController {
	private final UsuarioService usuarioservice;

	@Autowired
	public UsuarioController(UsuarioService usuarioservice) {
		super();
		this.usuarioservice = usuarioservice;
	}//constructor 
	
	@GetMapping 
	public List<Usuario> getUsuarios(){
		return usuarioservice.getUsuarios();
	}//getUsuarios
	
	@GetMapping (path="{userId}")
	public Usuario getUsuario(@PathVariable("userId") Long userId){
		return usuarioservice.getUsuario(userId);
	}//getUsuarios
	
	@DeleteMapping(path="{userId}")
	public Usuario deleteUsuario(@PathVariable("userId") Long userId) {
		return usuarioservice.deleteUsuario(userId);
		
	}
	
	@PostMapping 
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		return usuarioservice.addUsuario(usuario);
	}
	
	@PutMapping(path="{userId}") //http://localhost:8080/api/usuario/1
	public Usuario updateUsuario(@PathVariable("userId") Long userId, 
			@RequestBody ChangePassword changePassword) {
		return usuarioservice.updateUsuario(userId, changePassword.getPassword(),
				changePassword.getNewPassword());
	}

}
