package com.qpets.qpetsproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mascotas")

public class Mascota {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="mascota_id", unique=true, nullable=false)
	private Integer mascota_id;
	
	@Column(name="nombre_mascota")
	private String nombre_mascota;
	
	public Mascota(Integer id, String nombre_mascota) {
		
		super();
		this.mascota_id = id;
		this.nombre_mascota = nombre_mascota;
	}//constructor
	
	public Mascota() {};
	
	//getNombre
	public String getNombre_mascota() {
		return nombre_mascota;
	}
	
	//setNombre
	public void setNombre_mascota(String nombre_mascota) {
		this.nombre_mascota = nombre_mascota;
	}
	
	//getId
	public Integer getId() {
		return mascota_id;
	}
	

	@Override
	public String toString() {
		return "Mascota [id=" + mascota_id + ", nombre_mascota=" + nombre_mascota + "]";
	}
	
	
	
	
}//class Mascota
