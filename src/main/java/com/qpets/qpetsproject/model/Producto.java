package com.qpets.qpetsproject.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="producto_id", unique=true, nullable=false)
	private Integer producto_id;
	private String nombre_producto;
	private String descripcion;
	private BigDecimal precio;
	@Column(name="imagen")
	private String imagen;
	private Integer mascota_id;
	private Integer categoria_id;
	public Producto(Integer producto_id, String nombre_producto, String descripcion, BigDecimal precio, String imagen,
			Integer mascota_id, Integer categoria_id) {
		super();
		this.producto_id = producto_id;
		this.nombre_producto = nombre_producto;
		this.descripcion = descripcion;
		this.precio = precio;
		this.imagen = imagen;
		this.mascota_id = mascota_id;
		this.categoria_id = categoria_id;
	}//constructor

	public Producto() { }//constructor

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Integer getProducto_id() {
		return producto_id;
	}

	public Integer getMascotas_mascota_id() {
		return mascota_id;
	}

	public Integer getCategorias_categoria_id() {
		return categoria_id;
	}

	@Override
	public String toString() {
		return "Producto [producto_id=" + producto_id + ", nombre_producto=" + nombre_producto + ", descripcion="
				+ descripcion + ", precio=" + precio + ", imagen=" + imagen + ", mascotas_mascota_id="
				+ mascota_id + ", categoria_id=" + categoria_id + "]";
	}//toString
	
	
	
}//class Producto
