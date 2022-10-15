package com.qpets.qpetsproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qpets.qpetsproject.model.Categoria;

@Service //Se detecta esta clase como un servicio
public class CategoriaService {
	private final CategoriaRepository categoriaRepository;
	@Autowired //Al servidor le dice que va a instanciar mediante este constructor al servicio 
	public CategoriaService(CategoriaRepository categoriaRepository) {
		super();
		this.categoriaRepository = categoriaRepository;
	}//constructor
	
	public List<Categoria> getCategorias(){
		return categoriaRepository.findAll();
	}// getCategoriaS  //Este get busca todas las categorias
	
	public Categoria getCategoria(Integer id){
		return categoriaRepository.findById(id).orElseThrow(
				()->new IllegalArgumentException ("La categoría con el "+id+" no existe")
				);
	}// getCategoria //Este get busca la categoria por id
	
	public Categoria deleteCategoria (Integer id) {
		Categoria tmpCate = null;
		if(categoriaRepository.existsById(id)) {
			tmpCate = categoriaRepository.findById(id).get();
			categoriaRepository.deleteById(id);
		}//if exist
		return tmpCate;
	}
	
	public Categoria addCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}//addCategoria
	
	public Categoria updateCategoria(Integer id, String nombre) {
		Categoria tmpCate=null;
		if(categoriaRepository.existsById(id)) {
			tmpCate = categoriaRepository.findById(id).get();
			if(nombre!=null)tmpCate.setNombre(nombre);
			categoriaRepository.save(tmpCate);
		}//if exist
		else {
			System.out.println("Update - La categoría con el id "+id+" no existe");
		}
		return tmpCate;
	}//updateCategoria
	
	
	
}//class CategoriaService
















