package com.qpets.qpetsproject.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usiario")
public class Usuario { 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique= true, nullable= false)
private Long id;
@Column(name="email", nullable = false)

private String nombre;
@Column (name="password", nullable = false)
private String password;
public Usuario(Long id, String nombre, String password) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.password = password;
}//cons
public Usuario(){}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Long getId() {
	return id;
}

@Override
public String toString() {
	return "User [id=" + id + ", nombre=" + nombre + ", password=" + password + "]";
}

}


