package com.qpets.qpetsproject.service;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qpets.qpetsproject.model.Producto;
@Service
public class ProductoService {
	private final ProductoRepository productoRepository;
	@Autowired
	public ProductoService(ProductoRepository productoRepository) {
		super();
		this.productoRepository = productoRepository;
	}//constructor
	public List<Producto> getProductos(){
		return productoRepository.findAll();
	}//getProductos

	public Producto getProducto(Integer id){
		return productoRepository.findById(id).orElseThrow(
				()->new IllegalArgumentException("El producto con el id " + id + " no existe")
				);
	}//getProducto
	
	public Producto deleteProducto (Integer id) {
		Producto tmpProd = null;
		if (productoRepository.existsById(id)) {
			tmpProd = productoRepository.findById(id).get();
			productoRepository.deleteById(id);
		}//if exist
		return tmpProd;
	}//deleteProducto
	public Producto addProducto(Producto producto) {
		return productoRepository.save(producto);
	}//addProducto
	public Producto updateProducto(Integer producto_id, String nombre_producto, String descripcion
			, BigDecimal precio, String imagen, Integer mascota_id, Integer categoria_id) {
		Producto tmpProd = null;
		if (productoRepository.existsById(producto_id)) {
			tmpProd = productoRepository.findById(producto_id).get();
			if (nombre_producto!=null) tmpProd.setNombre_producto(nombre_producto);
			if (descripcion!=null) tmpProd.setDescripcion(descripcion);
			if (precio!=null) tmpProd.setPrecio(precio);
			if (imagen!=null) tmpProd.setImagen(imagen);
			if (mascota_id!=null) tmpProd.setMascota_id(mascota_id);
			if (categoria_id!=null) tmpProd.setCategoria_id(categoria_id);
			productoRepository.save(tmpProd);
		} else {
			System.out.println("Update - El Producto con el id " + producto_id + " no existe.");
		}//if exist
		return tmpProd;
	}//udateProducto
}//classProductoService
