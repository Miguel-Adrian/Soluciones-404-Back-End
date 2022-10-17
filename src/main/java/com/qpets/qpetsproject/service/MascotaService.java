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
	
	public Mascota getMascota (Integer mascota_id) {
		return mascotaRepository.findById(mascota_id).orElseThrow(
				() -> new IllegalArgumentException("La categoría para mascota con el ID: " + mascota_id + " no existe.")
				);
	}//getMascota
	

	public Mascota deleteMascota(Integer mascota_id) {
		Mascota tmpMascota = null;
		if(mascotaRepository.existsById(mascota_id)) {
			tmpMascota = mascotaRepository.findById(mascota_id).get();
			mascotaRepository.deleteById(mascota_id);
		}//if exist
		return tmpMascota;
	}//deleteMascota
	
	public Mascota addMascota(Mascota mascota) {
		return mascotaRepository.save(mascota);
	}//addMascota
	
	public Mascota updateMascota(Integer mascota_id, String nombre_mascota) {
		Mascota tmpMascota = null;
		if(mascotaRepository.existsById(mascota_id)) {
			tmpMascota = mascotaRepository.findById(mascota_id).get();
			if (nombre_mascota != null) tmpMascota.setNombre_mascota(nombre_mascota);
			mascotaRepository.save(tmpMascota);
		}//if
		return tmpMascota;
	}//updateMascota
	
}// class MascotaService
