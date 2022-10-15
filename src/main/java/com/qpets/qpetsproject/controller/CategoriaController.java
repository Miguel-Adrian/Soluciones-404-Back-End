package com.qpets.qpetsproject.controller;

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

import com.qpets.qpetsproject.model.Categoria;
import com.qpets.qpetsproject.service.CategoriaService;

@RestController //Se indica que será un controlador
@RequestMapping(path="/api/categorias/") //Se define la ruta para llamar a la API
public class CategoriaController {
	
	private final CategoriaService categoriaService;
	
	@Autowired
	public CategoriaController(CategoriaService categoriaService) {
		super();
		this.categoriaService = categoriaService;
	}//constructor
	
	@GetMapping
	public List<Categoria> getAllcategorias(){
		return categoriaService.getCategorias();
	}//getAllcategorias
	
	@GetMapping(path="{cateId}") //http://localhost:8080/api/categoria/
	public Categoria getCategoria(@PathVariable("cateId") Integer id) {
		return categoriaService.getCategoria(id);
	}//getCategoria
	
	@DeleteMapping(path="{cateId}")
	public Categoria deleteCategoria(@PathVariable("cateId") Integer id) {
		return categoriaService.deleteCategoria(id);
	}//deleteCategoria
	
	@PostMapping
	public Categoria addCategoria(@RequestBody Categoria categoria) {
		return categoriaService.addCategoria(categoria);
	}//addCategoria
	
	@PutMapping(path="{cateId}")
	public Categoria updateCategoria(@PathVariable("cateId") Integer id, 
			@RequestParam (required = false) String nombre) {
		return categoriaService.updateCategoria(id, nombre);
	}

}//class CategoriaController




