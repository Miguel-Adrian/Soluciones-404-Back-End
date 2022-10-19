package com.example.soluciones.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.soluciones.service.UsuarioService;

@RestController
@RequestMapping(path="/api/login/")
public class LoginController {
  private final UsuarioService usuarioService;
@Autowired
public LoginController(UsuarioService usuarioService) {
	super();
	this.usuarioService = usuarioService;
}//constructor
  @PostMapping
  public Token Login (@RequestBody Usuario usuario) {
	  if (usuarioService.validaUsuario(usuario)) {
		  return new Token(generateToken(usuario.getUsername()));
	  }
	  throw new ServletExeption("Nombre de usuario o contraseña incorrecta. ");
  }
  private String generateToken(String username) {Calendar calendar = Calendar.getInstance();calendar.add(Calendar.HOUR, 10);return Jwts.builder().setSubject(username).claim("role", "user").setIssuedAt(new Date()).setExpiration(calendar.getTime()).signWith(SignatureAlgorithm.HS256, JwtFilter.secret).compact();}// generateToken
}
