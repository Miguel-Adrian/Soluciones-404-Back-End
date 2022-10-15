package com.qpets.qpetsproject.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qpets.qpetsproject.model.Carrito;

@Service
public class CarritoService{
	private final CarritoRepository carritoRepository;
	
	@Autowired
	public CarritoService(CarritoRepository carritoRepository) {
		super();
		this.carritoRepository = carritoRepository;
	} // constructor
	
	public List<Carrito> getCarritos(){
		return carritoRepository.findAll();
	} // getCarritos
	
	public Carrito getCarrito(Integer carritoId){
		return carritoRepository.findById(carritoId).orElseThrow(
				()-> new IllegalArgumentException("El carrito con el id " + carritoId + " no existe")
				);
	} // getCarrito
	
	public Carrito deleteCarrito (Integer carritoId) {
		Carrito tmpCart = null;
		if (carritoRepository.existsById(carritoId)) {
			tmpCart = carritoRepository.findById(carritoId).get();
			carritoRepository.deleteById(carritoId);
		} // if exists
		return tmpCart;
	} // deleteProducto
	
	public Carrito addCarrito(Carrito carrito){
		return carritoRepository.save(carrito);
	} // addCarrito
	
	public Carrito updateCarrito(Integer carritoId, BigDecimal costoTotal, Integer totalProductos, Integer usuarioId) {
		Carrito tmpCart = null;
		if (carritoRepository.existsById(carritoId)) {
			tmpCart = carritoRepository.findById(carritoId).get();
			if(costoTotal != null) tmpCart.setCostoTotal(costoTotal);
			if(totalProductos != null) tmpCart.setTotalProductos(totalProductos);
			if(usuarioId != null) tmpCart.setUsuarioId(usuarioId);
			carritoRepository.save(tmpCart);
		} else {
			System.out.println("Update: El producto con el id " + carritoId + " no existe.");
		} // if else
		return tmpCart;
	} // updateCarrito
	
	
	
} // CarritoService
