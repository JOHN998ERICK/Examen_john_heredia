package com.idat.examen1_johnHeredia.servicio;

import java.util.List;

import com.idat.examen1_johnHeredia.dto.CursoDTORequest;
import com.idat.examen1_johnHeredia.dto.CursoDTOResponse;
import com.idat.examen1_johnHeredia.modelo.Curso;


public interface CursoServicio {
	public void guardarCurso(Curso curso);
	public void editarCurso(Curso curso);
	public void eliminarCurso(Integer id);
	public List<CursoDTOResponse> listarCurso();
	public CursoDTOResponse obtenerCurso(Integer id);
}
