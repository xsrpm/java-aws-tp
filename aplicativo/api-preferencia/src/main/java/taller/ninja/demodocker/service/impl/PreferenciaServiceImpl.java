package taller.ninja.demodocker.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import taller.ninja.demodocker.dao.PreferenciaDAO;
import taller.ninja.demodocker.exception.PersonaNotFoundException;
import taller.ninja.demodocker.model.Persona;
import taller.ninja.demodocker.model.Preferencia;
import taller.ninja.demodocker.service.PreferenciaService;

@Service
public class PreferenciaServiceImpl implements PreferenciaService {

	private static final Logger logger = LoggerFactory.getLogger(PreferenciaServiceImpl.class);

	@Autowired
	private PreferenciaDAO dao;

	@Autowired
	private RestTemplate template;

	@Value("${url.api.persona}")
	private String url;

	@Override
	public List<Preferencia> obtenerPreferenciaPorPersona(int idPersona) throws PersonaNotFoundException {
		logger.info("URL: " + (url + idPersona));
		ResponseEntity<Persona> rpta = template.getForEntity(url + idPersona, Persona.class);
		if(HttpStatus.INTERNAL_SERVER_ERROR == rpta.getStatusCode()){
			throw new PersonaNotFoundException();
		}
		return this.dao.obtenerPreferenciaPorPersona(idPersona);
	}

	@Override
	public List<Preferencia> listarTodos() {
		return this.dao.findAll();
	}

	@Override
	public void guardarDatos(Preferencia preferencia) {
		this.dao.save(preferencia);
	}

	@Override
	public void eliminarDatos(int preferenciaId) {
		this.dao.deleteById(preferenciaId);
	}

}
