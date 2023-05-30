package it.corso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import it.corso.model.Opera;

public interface OperaDao extends CrudRepository<Opera, Integer> {

	@Query(value = "SELECT * FROM opere ORDER BY id DESC LIMIT 2", nativeQuery = true)
	List<Opera> getLastOpera();
}
