package taller.ninja.demodocker.service;

import java.util.List;

import taller.ninja.demodocker.model.Persona;

public interface PersonaService {

	List<Persona> obtenerPorRangoEdad(
			int edadMenor,
			int edadMayor);
	
	List<Persona> listarTodos();
	Persona obtenerPorId(int idPersona);
	void guardarDatos(Persona persona);
	void eliminarDatos(int personaId);
}
