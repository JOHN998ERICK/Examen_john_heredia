package com.idat.examen1_johnHeredia.servicio;

import java.util.List;

import com.idat.examen1_johnHeredia.modelo.Profesor;

public interface ProfesorServicio {

	public void guardarProfesor(Profesor profesor);
	public void editarProfesor(Profesor profesor);
	public void eliminarProfesor(Integer id);
	public List<Profesor> listarProfesor();
	public Profesor obtenerProfesor(Integer id);

}
