package com.qpets.qpetsproject.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO

@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
	private int id;
    private String nombreUsuario;
	private String apellidoUsuario;
	@Column(name="email", nullable=false)
	private String email;
	private double telefono;
	@Column(name="contrasenia", nullable= false)
	private String contrasenia;
	public Usuario(int id, String nombreUsuario, String apellidoUsuario, String email, double telefono,
			String contrasenia) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.apellidoUsuario = apellidoUsuario;
		this.email = email;
		this.telefono = telefono;
		this.contrasenia = contrasenia;
	}//constructor 
	
	public Usuario() { }//constructor 

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidoUsuario() {
		return apellidoUsuario;
	}

	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getTelefono() {
		return telefono;
	}

	public void setTelefono(double telefono) {
		this.telefono = telefono;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", nombreUsuario=" + nombreUsuario + ", apellidoUsuario=" + apellidoUsuario
				+ ", email=" + email + ", telefono=" + telefono + ", contrasenia=" + contrasenia + "]";
	}//toString 
	
	
	
	
	

	
	
	
	
	
}//class Producto 
