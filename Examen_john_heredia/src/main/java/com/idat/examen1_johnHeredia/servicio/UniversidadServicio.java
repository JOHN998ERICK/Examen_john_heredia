package com.idat.examen1_johnHeredia.servicio;

import java.util.List;

import com.idat.examen1_johnHeredia.modelo.Universidad;

public interface UniversidadServicio {

	public void guardarUniversidad(Universidad universidad);
	public void editarUniversidad(Universidad universidad);
	public void eliminarUniversidad(Integer id);
	public List<Universidad> listarUniversidad();
	public Universidad obtenerUniversidad(Integer id);
	
}
