package com.qpets.qpetsproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qpets.qpetsproject.model.Mascota;

@Service
public class MascotaService {
	private final MascotaRepository mascotaRepository;

	@Autowired
	public MascotaService(MascotaRepository mascotaRepository) {
		super();
		this.mascotaRepository = mascotaRepository;
	}//constructor
	
	public List<Mascota> getMascotas() {
		return mascotaRepository.findAll();
	}//getMascotas
	
	public Mascota getMascota (Integer id) {
		return mascotaRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("La categoría para mascota con el ID: " + id + " no existe.")
				);
	}//getMascota
	

	public Mascota deleteMascota(Integer id) {
		Mascota tmpMascota = null;
		if(mascotaRepository.existsById(id)) {
			tmpMascota = mascotaRepository.findById(id).get();
			mascotaRepository.deleteById(id);
		}//if exist
		return tmpMascota;
	}//deleteMascota
	
	public Mascota addMascota(Mascota mascota) {
		return mascotaRepository.save(mascota);
	}//addMascota
	
	public Mascota updateMascota(Integer id, String nombre) {
		Mascota tmpMascota = null;
		if(mascotaRepository.existsById(id)) {
			tmpMascota = mascotaRepository.findById(id).get();
			if (nombre != null) tmpMascota.setNombre_mascota(nombre);
			mascotaRepository.save(tmpMascota);
		}//if
		return tmpMascota;
	}//updateMascota
	
}// class MascotaService
