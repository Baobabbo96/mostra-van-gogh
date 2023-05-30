package it.corso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.corso.model.Evento;

public interface EventoDao extends CrudRepository<Evento, Integer> {
	
	@Query(value = "SELECT * FROM eventi ORDER BY id DESC LIMIT 2", nativeQuery = true) 
	List<Evento> getLastEvento();

}
