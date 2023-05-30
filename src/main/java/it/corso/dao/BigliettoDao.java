package it.corso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.corso.model.Biglietto;

public interface BigliettoDao extends CrudRepository<Biglietto, Integer>{
	
	@Query(value = "SELECT * FROM biglietti ORDER BY id DESC LIMIT 2", nativeQuery = true)
	List<Biglietto> getLastBiglietto();

}
