package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.EventoDao;
import it.corso.model.Evento;

@Service
public class EventoServiceImpl implements EventoService {

	@Autowired
	private EventoDao eventoDao;
	
	@Override
	public void registraEvento(Evento evento) {
		// TODO Auto-generated method stub

	}

	@Override
	public Evento getEventoById(int id) {
		
		return eventoDao.findById(id).get();
	}

	@Override
	public List<Evento> getEventi() {
		return (List<Evento>) eventoDao.findAll();
	}

	@Override
	public void cancellaEvento(Evento evento) {
		eventoDao.delete(evento);
	}

	@Override
	public List<Evento> getLasEvento() {
		return eventoDao.getLastEvento();
	}

}
