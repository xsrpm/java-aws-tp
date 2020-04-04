package taller.ninja.demodocker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import taller.ninja.demodocker.dao.PersonaDAO;
import taller.ninja.demodocker.model.Persona;
import taller.ninja.demodocker.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaDAO dao;

	@Override
	public List<Persona> obtenerPorRangoEdad(int edadMenor, int edadMayor) {
		return this.dao.obtenerPorRangoEdad(edadMenor, edadMayor);
	}

	@Override
	public List<Persona> listarTodos() {
		return this.dao.findAll();
	}

	@Override
	public void guardarDatos(Persona persona) {
		this.dao.save(persona);
	}

	@Override
	public void eliminarDatos(int personaId) {
		this.dao.deleteById(personaId);
	}

	@Override
	public Persona obtenerPorId(int idPersona) {
		return this.dao.findById(idPersona).get();
	}

}
