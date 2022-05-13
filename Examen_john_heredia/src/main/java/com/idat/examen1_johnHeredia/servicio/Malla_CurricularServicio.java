package com.idat.examen1_johnHeredia.servicio;

import java.util.List;

import com.idat.examen1_johnHeredia.modelo.Malla_Curricular;

public interface Malla_CurricularServicio {
	public void guardarMalla_Curricular(Malla_Curricular malla);
	public void editarMalla_Curricula(Malla_Curricular malla);
	public void eliminarMalla_Curricula(Integer id);
	public List<Malla_Curricular> listarMalla_Curricula();
	public Malla_Curricular obtenerMalla_Curricular(Integer id);

}
