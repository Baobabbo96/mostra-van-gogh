package it.corso.dao;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Biglietto;

public interface BigliettoDao extends CrudRepository<Biglietto, Integer>{

}
