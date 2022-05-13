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

import com.idat.examen1_johnHeredia.modelo.Profesor;

import com.idat.examen1_johnHeredia.servicio.ProfesorServicio;


@RestController
@RequestMapping("/profesor")
public class ProfesorControlador {
	@Autowired
	private ProfesorServicio servicio;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity< List<Profesor>> listarProfesor(){
		return new ResponseEntity<List<Profesor>>(servicio.listarProfesor(), HttpStatus.CREATED);
	}
	
	@RequestMapping(path="/guardar", method=RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Profesor profesor){
		servicio.guardarProfesor(profesor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path ="/listar/{id}")
	public ResponseEntity<Profesor> listarPorId(@PathVariable Integer id){
		Profesor p=servicio.obtenerProfesor(id);
	   if(p!= null) 
	       return new ResponseEntity<Profesor>(p, HttpStatus.OK);
	   
	    return new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path="/editar", method=RequestMethod. PATCH)
	public ResponseEntity<Void> editar(@RequestBody Profesor profesor){
		Profesor p=servicio.obtenerProfesor(profesor.getIdProfesor());
	    if(p != null){
	        servicio.editarProfesor(profesor);
	        return new ResponseEntity<Void>(HttpStatus.OK);
	    }
	    return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);   
	}
	
	@RequestMapping(path="/eliminar/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Profesor p=servicio.obtenerProfesor(id);
	    if(p != null){
	        servicio.eliminarProfesor(id);
	        return new ResponseEntity<Void>(HttpStatus.OK);
	    }
	    return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);
	}

}
