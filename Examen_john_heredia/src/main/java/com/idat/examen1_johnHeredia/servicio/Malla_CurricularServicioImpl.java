package com.idat.examen1_johnHeredia.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.examen1_johnHeredia.modelo.Malla_Curricular;
import com.idat.examen1_johnHeredia.repositorio.Malla_CurricularRepositorio;
;

@Service
public class Malla_CurricularServicioImpl implements Malla_CurricularServicio{

	@Autowired
	public Malla_CurricularRepositorio repositorio;
	
	@Override
	public void guardarMalla_Curricular(Malla_Curricular malla) {
		// TODO Auto-generated method stub
		repositorio.save(malla);
	}

	@Override
	public void editarMalla_Curricula(Malla_Curricular malla) {
		// TODO Auto-generated method stub
		repositorio.saveAndFlush(malla);
	}

	@Override
	public void eliminarMalla_Curricula(Integer id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

	@Override
	public List<Malla_Curricular> listarMalla_Curricula() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Malla_Curricular obtenerMalla_Curricular(Integer id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).orElse(null);
	}

}
