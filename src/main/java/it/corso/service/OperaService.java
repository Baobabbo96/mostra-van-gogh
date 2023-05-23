package it.corso.service;

import java.util.List;
import it.corso.model.Opera;

public interface OperaService 
{
	void registraOpera(Opera opera, Object... dati);
	Opera getOperaById(int id);
	List<Opera> getOpere();
	void cancellaOpera(Opera opera);	
}
