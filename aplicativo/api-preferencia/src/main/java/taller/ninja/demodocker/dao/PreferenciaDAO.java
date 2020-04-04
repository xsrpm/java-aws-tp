package taller.ninja.demodocker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import taller.ninja.demodocker.model.Preferencia;

@Repository
public interface PreferenciaDAO extends JpaRepository<Preferencia, Integer>{

    @Query("SELECT s FROM Preferencia s WHERE (s.idPersona = :idPersona)")
	public List<Preferencia> obtenerPreferenciaPorPersona(@Param("idPersona") int idPersona);
}
