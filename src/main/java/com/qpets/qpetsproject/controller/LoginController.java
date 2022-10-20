package com.qpets.qpetsproject.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qpets.qpetsproject.service.UsuarioService;
import com.qpets.qpetsproject.jwt.config.JwtFilter;
import com.qpets.qpetsproject.model.Token;
import com.qpets.qpetsproject.model.Usuario;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(path="/api/login/")
public class LogInController {
	
  private final UsuarioService usuarioService;

 @Autowired
public LogInController(UsuarioService usuarioService) {
	super();
	this.usuarioService = usuarioService;
}//constructor
  @PostMapping
  public Token LogIn (@RequestBody Usuario usuario) throws ServletException {
	  if (usuarioService.validaUsuario(usuario)) {
		  return new Token(generateToken(usuario.getEmail()));
	  }
	  throw new ServletException("Email o contrasena incorrecta. ");
  }
  private String generateToken(String username) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, 1);
		return Jwts.builder().setSubject(username).claim("role", "user")
				.setIssuedAt(new Date()).setExpiration(calendar.getTime())
				.signWith(SignatureAlgorithm.HS256, JwtFilter.secret).compact();
	} // generateToken
}
