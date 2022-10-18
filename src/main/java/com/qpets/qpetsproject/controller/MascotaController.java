package com.qpets.qpetsproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qpets.qpetsproject.model.Mascota;
import com.qpets.qpetsproject.service.MascotaService;

@RestController
@RequestMapping(path="api/mascotas/")
public class MascotaController {
	
	private final MascotaService mascotaService;


	
	@Autowired
	public MascotaController(MascotaService mascotaService) {
		super();
		this.mascotaService = mascotaService;
	}//constructor
	
	@GetMapping
	public List<Mascota> getAllMascotas(){
		return mascotaService.getMascotas();
	}//getAllMascotas
	
	@GetMapping (path="{mascotaId}")
	public Mascota getMascota(@PathVariable("mascotaId")Integer mascota_id) {
		return mascotaService.getMascota(mascota_id);
	}//getMascota
	
	@DeleteMapping (path="{mascotaId}")
	public Mascota deleteMascota(@PathVariable("mascotaId")Integer mascota_id) {
		return mascotaService.deleteMascota(mascota_id);
	}//deleteMascota
	
	@PostMapping
	public Mascota addMascota(@RequestBody Mascota mascota) {
		return mascotaService.addMascota(mascota);
	}//addMascota
	
	@PutMapping (path="{mascotaId}")
	public Mascota updateMascota(@PathVariable("mascotaId")Integer mascota_id,
		@RequestParam (required = false) String nombre_mascota){
			return mascotaService.updateMascota(mascota_id, nombre_mascota);
	}//updateMascota
	
	

}//class MascotaController
