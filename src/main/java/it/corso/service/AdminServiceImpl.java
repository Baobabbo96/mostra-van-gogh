package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.AdminDao;
import it.corso.model.Admin;
import jakarta.servlet.http.HttpSession;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao;

	@Override
	public void registraAdmin(Object... dati) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Admin getAdminById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> getAdmin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancellaAdmin(Admin admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean controlloLogin(HttpSession session, String... credenziali) {
		Admin admin = adminDao.findByUsernameAndPassword(credenziali[0], credenziali[1]);
		if(admin == null)
			return false;
		session.setAttribute("admin", admin);
		return true;
	}

}
