package com.qpets.qpetsproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// POJO - Plain Java Object

@Entity //Se indica que es una entidad
@Table(name = "categorias") //Se establece el nombre de la tabla en la base de datos

public class Categoria {
	@Id //Es un id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Genera automaticamente
	@Column(name="categoria_id", unique = true, nullable=false) //Es unico y no nulo
	private Integer categoria_id; //Solo para lectura 
	@Column(name="nombre_categoria", unique = true, nullable=false) //Es unico y no nulo
	private String nombre_categoria;
	
	public Categoria(Integer id, String nombre) {
		super();
		this.categoria_id = id;
		this.nombre_categoria = nombre;
	}//constructor
	
	public Categoria() {
		super();
	}// Constructor vacio para metodo post

	public String getNombre() {
		return nombre_categoria;
	}//getNombre
	
	public void setNombre(String nombre) {
		this.nombre_categoria = nombre;
	}//setNombre
	
	public Integer getId() {
		return categoria_id;
	}//getId

	@Override
	public String toString() {
		return "Categorias [id=" + categoria_id + ", nombre=" + nombre_categoria + "]";
	}
	
	
	
	

}
