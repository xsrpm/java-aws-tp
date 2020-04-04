package taller.ninja.demodocker.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import taller.ninja.demodocker.dto.RespuestaApi;
import taller.ninja.demodocker.exception.PersonaNotFoundException;
import taller.ninja.demodocker.model.Preferencia;
import taller.ninja.demodocker.service.PreferenciaService;

@RestController
@CrossOrigin
@RequestMapping("api/preferencias")
public class ApiPreferenciaController {
	
	private static final Logger logger = LoggerFactory.getLogger(ApiPreferenciaController.class);

	@Autowired
	private PreferenciaService service;

	@GetMapping(value="persona/{idPersona}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Preferencia>> obtenerTodos(
			@PathVariable int idPersona){
		try {
			ResponseEntity<List<Preferencia>> rpta =  new ResponseEntity<List<Preferencia>>(
				service.obtenerPreferenciaPorPersona(idPersona), HttpStatus.OK);
			logger.info("[listar] Devolucion preferencia de persona {0} correcta", idPersona);
			return rpta;
		}catch(PersonaNotFoundException e){
			ResponseEntity<List<Preferencia>> rpta =  new ResponseEntity<List<Preferencia>>(
				new ArrayList<Preferencia>(), HttpStatus.NOT_ACCEPTABLE);
				logger.error("idPersona no valida para la consulta");
				return rpta;
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Preferencia>> obtenerTodos(){
		try {
			ResponseEntity<List<Preferencia>> rpta = new ResponseEntity<List<Preferencia>>(service.listarTodos(), HttpStatus.OK);
			logger.info("[listar] Devolucion correcta");
			return rpta;
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value="registrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaApi> guardar(
			@RequestBody Preferencia preferencia){
		try {
			service.guardarDatos(preferencia);
			logger.info("Se guardo correctamente");
			return new ResponseEntity<RespuestaApi>(new RespuestaApi("OK",""), HttpStatus.OK);
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaApi> eliminar(
			@PathVariable int id){
		try {
			service.eliminarDatos(id);
			logger.info("Se elimino correctamente");
			return new ResponseEntity<RespuestaApi>(new RespuestaApi("OK",""), HttpStatus.OK);
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
