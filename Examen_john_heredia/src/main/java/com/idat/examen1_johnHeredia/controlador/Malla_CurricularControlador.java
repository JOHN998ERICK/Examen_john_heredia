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

import com.idat.examen1_johnHeredia.modelo.Malla_Curricular;
import com.idat.examen1_johnHeredia.servicio.Malla_CurricularServicio;



@RestController
@RequestMapping("/malla")
public class Malla_CurricularControlador {
	
	@Autowired
	private Malla_CurricularServicio servicio;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity< List<Malla_Curricular>> listarMalla_Curricular(){
		return new ResponseEntity<List<Malla_Curricular>>(servicio.listarMalla_Curricula(), HttpStatus.CREATED);
	}
	
	@RequestMapping(path="/guardar", method=RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Malla_Curricular malla){
		servicio.guardarMalla_Curricular(malla);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path ="/listar/{id}")
	public ResponseEntity<Malla_Curricular> listarPorId(@PathVariable Integer id){
		Malla_Curricular p=servicio.obtenerMalla_Curricular(id);
	   if(p!= null) 
	       return new ResponseEntity<Malla_Curricular>(p, HttpStatus.OK);
	   
	    return new ResponseEntity<Malla_Curricular>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path="/editar", method=RequestMethod. PATCH)
	public ResponseEntity<Void> editar(@RequestBody Malla_Curricular malla){
		Malla_Curricular p=servicio.obtenerMalla_Curricular(malla.getIdMalla());
	    if(p != null){
	        servicio.editarMalla_Curricula(malla);
	        return new ResponseEntity<Void>(HttpStatus.OK);
	    }
	    return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);   
	}
	
	@RequestMapping(path="/eliminar/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Malla_Curricular p=servicio.obtenerMalla_Curricular(id);
	    if(p != null){
	        servicio.eliminarMalla_Curricula(id);
	        return new ResponseEntity<Void>(HttpStatus.OK);
	    }
	    return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);
	}

}
