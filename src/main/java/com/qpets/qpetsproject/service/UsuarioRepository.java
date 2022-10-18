package com.qpets.qpetsproject.service;


	import org.springframework.data.jpa.repository.JpaRepository;

	import com.example.soluciones.model.Usuario;

	public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	}

}
