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

import com.qpets.qpetsproject.model.Producto;
import com.qpets.qpetsproject.service.ProductoService;
@RestController
@RequestMapping(path="/api/productos/")
public class ProductoController {
	private final ProductoService productoService;
	
	@Autowired
	public ProductoController(ProductoService productoService) {
		super();
		this.productoService = productoService;
	}//constructor
	
	@GetMapping
	public List<Producto> getAllProductos(){
		return productoService.getProductos();
	}//getAllProductos
	
	@GetMapping (path="{prodId}")
	public Producto getProducto(@PathVariable("prodId") Integer id){
		return productoService.getProducto(id);
	}//getAllProductos
	
	@DeleteMapping(path="{prodId}")
	public Producto deleteProducto(@PathVariable("prodId") Integer id){
		return productoService.deleteProducto(id);
	}//deleteProducto
	
	@PostMapping
	public Producto addProducto(@RequestBody Producto producto) {
		return productoService.addProducto(producto);
	}//addProducto
	
	@PutMapping(path="{prodId}")
	public Producto updateProducto (@PathVariable("prodId") Integer id,
			@RequestParam (required = false) String nombre_producto,
			@RequestParam (required = false) String descripcion,
			@RequestParam (required = false) BigDecimal precio,
			@RequestParam (required = false) String imagen) {
		return productoService.updateProducto(id, nombre_producto, descripcion, precio, imagen, id, id);
	}//updateProducto

}//class ProductoController
