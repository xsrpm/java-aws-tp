package taller.ninja.demodocker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import taller.ninja.demodocker.model.Persona;

@Repository
public interface PersonaDAO extends JpaRepository<Persona, Integer>{

	@Query("SELECT s FROM Persona s WHERE (s.edad BETWEEN :edadMenor AND :edadMayor)")
	public List<Persona> obtenerPorRangoEdad(
			@Param("edadMenor") int edadMenor,
			@Param("edadMayor") int edadMayor);
}
