package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.OperaDao;
import it.corso.model.Opera;

@Service
public class OperaServiceImpl implements OperaService {

	@Autowired
	private OperaDao operaDao;
	
	@Override
	public void registraOpera(Opera opera) {
		operaDao.save(opera);
	}

	@Override
	public Opera getOperaById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Opera> getOpere() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancellaOpera(Opera opera) {
		// TODO Auto-generated method stub

	}

}
