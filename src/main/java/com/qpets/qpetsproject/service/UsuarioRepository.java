package com.qpets.qpetsproject.service;

import java.util.Optional;

import com.qpets.qpetsproject.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	@Query("SELECT u FROM Usuario u WHERE u.email=?1")  // JPQL
	Optional<Usuario> findByUsername(String email);
}