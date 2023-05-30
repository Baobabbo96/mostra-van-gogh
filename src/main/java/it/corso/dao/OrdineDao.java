package it.corso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.corso.model.Ordine;

public interface OrdineDao extends CrudRepository<Ordine, Integer> {
	
	@Query(value = "SELECT * FROM ordini ORDER BY id DESC LIMIT 2", nativeQuery = true) 
	List<Ordine> getLastOrdini();
}
