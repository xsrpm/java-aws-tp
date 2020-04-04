package taller.ninja.demodocker.service;

import java.util.List;

import taller.ninja.demodocker.exception.PersonaNotFoundException;
import taller.ninja.demodocker.model.Preferencia;

public interface PreferenciaService {

	List<Preferencia> obtenerPreferenciaPorPersona(int idPersona) throws PersonaNotFoundException;
	
	List<Preferencia> listarTodos();
	void guardarDatos(Preferencia preferencia);
	void eliminarDatos(int preferenciaId);
}
