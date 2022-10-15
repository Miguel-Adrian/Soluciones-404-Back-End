package com.qpets.qpetsproject.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Definir como entidad
@Table(name = "carritos") //Nombre de la tabla
public class Carrito {
	
	@Id // ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Genera automáticamente
	@Column(name = "carrito_id", unique = true, nullable = false) // único y no es nulo 
	private Integer carritoId;
	@Column(name = "costo_total")
	private BigDecimal costoTotal;
	@Column(name = "total_productos")
	private Integer totalProductos;
	@Column(name = "usuario_id")
	private Integer usuarioId;
	public Carrito (Integer carritoId, BigDecimal costoTotal, Integer totalProductos, Integer usuarioId) {
		super();
		this.carritoId = carritoId;
		this.costoTotal = costoTotal;
		this.totalProductos = totalProductos;
		this.usuarioId = usuarioId;
	} // constructor
	
	public Carrito () {} // Constructor vacío

	public Integer getCarritoId() {
		return carritoId;
	} // carritoId

	public BigDecimal getCostoTotal() {
		return costoTotal;
	} // getCostoTotal

	public void setCostoTotal(BigDecimal costoTotal) {
		this.costoTotal = costoTotal;
	} // setCostoTotal

	public Integer getTotalProductos() {
		return totalProductos;
	} // getTotalProductos

	public void setTotalProductos(Integer totalProductos) {
		this.totalProductos = totalProductos;
	} // setTotalProductos

	public Integer getUsuarioId() {
		return usuarioId;
	} // getUsuarioId

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	} // setUsuarioId

	@Override
	public String toString() {
		return "Carrito [carritoId=" + carritoId + ", costoTotal=" + costoTotal + ", totalProductos=" + totalProductos
				+ ", usuarioId=" + usuarioId + "]";
	} // toString
	
	
} // Carrito
