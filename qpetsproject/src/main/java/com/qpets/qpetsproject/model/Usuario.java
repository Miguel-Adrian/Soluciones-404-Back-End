package com.qpets.qpetsproject.model;

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
    @Column(name="usuario_id", unique=true, nullable=false)
	private Integer id;
    @Column(name="nombre_usuario", nullable=false)
    private String nombreUsuario;
    @Column(name="apellido_usuario", nullable=false)
	private String apellidoUsuario;
	@Column(name="email", nullable=false)
	private String email;
	@Column(name="telefono", nullable=false)
	private String telefono;
	@Column(name="contrasenia", nullable= false)
	private String password;
	public Usuario(Integer id, String nombreUsuario, String apellidoUsuario, String email, String telefono,
			String password) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.apellidoUsuario = apellidoUsuario;
		this.email = email;
		this.telefono = telefono;
		this.password = password;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", nombreUsuario=" + nombreUsuario + ", apellidoUsuario=" + apellidoUsuario
				+ ", email=" + email + ", telefono=" + telefono + ", contrasenia=" + password + "]";
	}//toString 
	
	
	
	
	

	
	
	
	
	
}//class Producto 
