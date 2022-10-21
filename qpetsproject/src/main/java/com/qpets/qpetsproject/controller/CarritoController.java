package com.qpets.qpetsproject.controller;

import java.math.BigDecimal;
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
import com.qpets.qpetsproject.model.Carrito;
import com.qpets.qpetsproject.service.CarritoService;

@RestController
@RequestMapping(path="/api/carritos/")
public class CarritoController {

	private final CarritoService carritoService;
	
	@Autowired
	public CarritoController (CarritoService carritoService) {
		super();
		this.carritoService = carritoService;
	} // constructor

	@GetMapping
	public List<Carrito> getAllCarritos(){
		return carritoService.getCarritos();
	} // getAllCarritos
	
	@GetMapping (path="{cartId}")
	public Carrito getCarrito(@PathVariable("cartId") Integer carritoId){
		return carritoService.getCarrito(carritoId);
	} // getCarrito
	
	@DeleteMapping(path= "{cartId}")
	public Carrito deleteProducto(@PathVariable("cartId") Integer carritoId) {
		return carritoService.deleteCarrito(carritoId);
	} // deleteCarrito
	
	@PostMapping
	public Carrito addCarrito(@RequestBody Carrito carrito) {
		return carritoService.addCarrito(carrito);
	} // addCarrito
	
	@PutMapping(path= "{cartId}")
	public Carrito updateCarrito (@PathVariable("cartId") Integer carritoId,
			@RequestParam (required = false) BigDecimal costoTotal,
			@RequestParam (required = false) Integer totalProductos,
			@RequestParam (required = false) Integer usuarioId) {
		return carritoService.updateCarrito(carritoId, costoTotal, totalProductos, usuarioId);
	} // updateCarrito
	
}
