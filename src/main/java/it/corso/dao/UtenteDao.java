package it.corso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.corso.model.Utente;

public interface UtenteDao extends CrudRepository<Utente, Integer> {

	Utente findByUsernameAndPassword(String username, String password);
	
	@Query(value = "SELECT * FROM utenti ORDER BY id DESC LIMIT 2", nativeQuery = true) 
	List<Utente> getLastUtenti();
}
