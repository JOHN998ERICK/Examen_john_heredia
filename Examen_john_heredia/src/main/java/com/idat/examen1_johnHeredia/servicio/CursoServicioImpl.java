package com.idat.examen1_johnHeredia.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.examen1_johnHeredia.dto.CursoDTOResponse;
import com.idat.examen1_johnHeredia.modelo.Curso;
import com.idat.examen1_johnHeredia.repositorio.CursoRepositorio;


@Service
public class CursoServicioImpl implements CursoServicio{

	@Autowired
	public CursoRepositorio repositorio;
	
	@Override
	public void guardarCurso(Curso curso) {
		// TODO Auto-generated method stub
		repositorio.save(curso);
	}

	@Override
	public void editarCurso(Curso curso) {
		// TODO Auto-generated method stub
		repositorio.saveAndFlush(curso);
	}

	@Override
	public void eliminarCurso(Integer id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

	@Override
	public List<Curso> listarCurso() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public CursoDTOResponse obtenerCurso(Integer id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).orElse(null);
	}

}
