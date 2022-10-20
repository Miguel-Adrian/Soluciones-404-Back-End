package com.qpets.qpetsproject.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qpets.qpetsproject.model.Usuario;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}//constructor



	public List<Usuario> getUsuarios() {
       
		return usuarioRepository.findAll();
	}//getUsuarios 
	
	public Usuario getUsuario(Integer userId) {
		return usuarioRepository.findById(userId).orElseThrow(
				()-> new IllegalStateException("El usuario con el id[" + userId + "] no existe."));		
	}

	public Usuario deleteUsuario(Integer userId) {
		Usuario tmpUsuario = null;
		if (usuarioRepository.existsById(userId)) {
			tmpUsuario = usuarioRepository.findById(userId).get();
			usuarioRepository.deleteById(userId);
		}//if
		return tmpUsuario;
	}//deleteUsuario



	public Usuario addUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}//addUsuario

	public Usuario updateUsuario(Integer userId, String nombreUsuario, String apellidoUsuario, String email,
			String telefono, String password, String newPassword) {
		Usuario tmpUsuario = null;
	      if(usuarioRepository.existsById(userId)) {
	    	  tmpUsuario = usuarioRepository.findById(userId).get();
	    	  if (nombreUsuario!=null) tmpUsuario.setNombreUsuario(nombreUsuario);
	          if (apellidoUsuario!=null) tmpUsuario.setApellidoUsuario(apellidoUsuario);
	          if (email!=null) tmpUsuario.setEmail(email);
	          if (telefono!=null) tmpUsuario.setTelefono(telefono);
	    	  if ((password !=null) && (newPassword!=null)) {
	    		  if(password.equals(tmpUsuario.getPassword())) {
	    			  tmpUsuario.setPassword(newPassword);
	    			  usuarioRepository.save(tmpUsuario);
	    		  }//if password.equals
	    	  }//if !=null
	      } else{
	    	  System.out.println("update - El usuario con el id " +  userId + " no existe."); 
	      } //if exist
		return tmpUsuario;
	} //updateUsuario
	
	public boolean validaUsuario(Usuario usuario) {
	    boolean res = false;
	    Optional<Usuario> userByUsername = usuarioRepository.findByUsername(usuario.getEmail());
		if(userByUsername.isPresent()) {
			Usuario u = userByUsername.get();
			if(u.getPassword().equals(usuario.getPassword()) ) {
				res = true;
			}//if password
		}//if
		return res;
	}//validaUsuario

}
