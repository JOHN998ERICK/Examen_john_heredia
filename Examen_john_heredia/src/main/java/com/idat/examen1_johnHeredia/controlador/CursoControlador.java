package com.idat.examen1_johnHeredia.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.examen1_johnHeredia.dto.CursoDTOResponse;
import com.idat.examen1_johnHeredia.modelo.Curso;

import com.idat.examen1_johnHeredia.servicio.CursoServicio;


@RestController
@RequestMapping("/curso")
public class CursoControlador {


	@Autowired
	private CursoServicio servicio;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity< List<Curso>> listarMalla_Curricular(){
		return new ResponseEntity<List<Curso>>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path="/guardar", method=RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Curso curso){
		servicio.guardarCurso(curso);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path ="/listar/{id}")
	public ResponseEntity<Curso> listarPorId(@PathVariable Integer id){
		CursoDTOResponse p=servicio.obtenerCurso(id);
	   if(p!= null) 
	       return new ResponseEntity<Curso>(HttpStatus.OK);
	   
	    return new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path="/editar", method=RequestMethod. PATCH)
	public ResponseEntity<Void> editar(@RequestBody Curso curso){
		CursoDTOResponse p=servicio.obtenerCurso(curso.getIdCurso());
	    if(p != null){
	        servicio.editarCurso(curso);
	        return new ResponseEntity<Void>(HttpStatus.OK);
	    }
	    return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);   
	}
	
	@RequestMapping(path="/eliminar/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		CursoDTOResponse p=servicio.obtenerCurso(id);
	    if(p != null){
	        servicio.eliminarCurso(id);
	        return new ResponseEntity<Void>(HttpStatus.OK);
	    }
	    return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);
	}
}
