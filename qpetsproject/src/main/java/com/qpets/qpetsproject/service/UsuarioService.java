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
	
	public Usuario getUsuario(Long userId) {
		return usuarioRepository.findById(userId).orElseThrow(
				()-> new IllegalStateException("El usuario con el id[" + userId + "] no existe."));		
	}

	public Usuario deleteUsuario(Long userId) {
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



	public Usuario updateUsuario(Long userId, String password, String newPassword) {
      Usuario tmpUsuario = null;
      if(usuarioRepository.existsById(userId)) {
    	  tmpUsuario = usuarioRepository.findById(userId).get();
    	  if ((password !=null) && (newPassword!=null)) {
    		  if(password.equals(tmpUsuario.getContrasenia())) {
    			  tmpUsuario.setContrasenia(newPassword);
    			  usuarioRepository.save(tmpUsuario);
    		  }//if password.equals
    	  }//if !=null
      }//if
	return tmpUsuario;
	}



	public boolean validaUsuario(Usuario usuario) {
	    boolean res = false;
	    Optional<Usuario> userByUsername = usuarioRepository.findByUsername(usuario.getNombreUsuario());
		if(userByUsername.isPresent()) {
			Usuario u = userByUsername.get();
			if(u.getContrasenia().equals(usuario.getContrasenia()) ) {
				res = true;
			}//if password
		}//if
		return res;
	}//validaUsuario
	
	
	
}
