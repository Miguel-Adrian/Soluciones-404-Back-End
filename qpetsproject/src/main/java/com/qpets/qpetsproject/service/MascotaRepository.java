package com.qpets.qpetsproject.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qpets.qpetsproject.model.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Integer> {
	

}//interface MascotaRepository
