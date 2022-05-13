package com.idat.examen1_johnHeredia.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.examen1_johnHeredia.modelo.Profesor;
import com.idat.examen1_johnHeredia.repositorio.ProfesorRepositorio;


@Service
public class ProfesorServicioImpl implements ProfesorServicio{

	@Autowired
	public ProfesorRepositorio repositorio;
	
	@Override
	public void guardarProfesor(Profesor profesor) {
		// TODO Auto-generated method stub
		repositorio.save(profesor);
	}

	@Override
	public void editarProfesor(Profesor profesor) {
		// TODO Auto-generated method stub
		repositorio.saveAndFlush(profesor);
	}

	@Override
	public void eliminarProfesor(Integer id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

	@Override
	public List<Profesor> listarProfesor() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Profesor obtenerProfesor(Integer id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).orElse(null);
	}

}
