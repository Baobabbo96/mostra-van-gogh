package it.corso.service;

import java.util.List;

import it.corso.model.Admin;


public interface AdminService {

	
	void registraAdmin(Object...Admin);
	Admin getAdminById(int id);
	List<Admin> getAdmin();
	void eliminaAdmin(Object...Admin);
}
