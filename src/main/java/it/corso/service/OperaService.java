package it.corso.service;

import java.util.List;
import it.corso.model.Opera;

public interface OperaService 
{
	void registraOpera(Opera opera);
	Opera getOperaById(int id);
	List<Opera> getOpere();
	void deleateOpera(Opera opera);	
}
