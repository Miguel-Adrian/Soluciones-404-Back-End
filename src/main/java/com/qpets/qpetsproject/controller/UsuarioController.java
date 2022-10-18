package com.qpets.qpetsproject.controller;

public class UsuarioController {
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import com.example.soluciones.model.ChangePassword;
	import com.example.soluciones.model.Usuario;
	import com.example.soluciones.service.UsuarioService;

	@RestController
	@RequestMapping(path="/api/usuario/")
	public class UsuarioController {
	 private final UsuarioService usuarioService;
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}

	@GetMapping
	public list<Usuario>getUsuario(){
		return usuarioService.getUsuarios();
	}
	@GetMapping (path="{userId}")
	public Usuario getUsuario(@PathVariable("userId")Long userId) {
		return usuarioService.deleteUsuario(userId);
	}
	@DeleteMapping (path="{userId}")
	public Usuario deleteUsuario(@PathVariable("userId") Long userId) {
		return usuarioService.deleteUsuario(userId);
	}
	@PostMapping 
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		return usuarioService.deleteUsuario(usuario);
		}
	@PutMapping (path="{userID}")
	public Usuario updateUsuario(@PathVariable("userId")Long userId,
		@RequestBody ChangePassword changePassword ) {
		ChangePassword chagePassword;
		return usuarioService.updateUsuario(userId, changePassword.getPassword(),
		chagePassword.getNewPassword());
	}

	}

}
