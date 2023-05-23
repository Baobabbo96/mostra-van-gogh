package it.corso.service;

import java.util.List;

import it.corso.model.Admin;


public interface AdminService {
	
	void registraAdmin(Object... dati);// non utile, si potrà eliminare.
	Admin getAdminById(int id);
	List<Admin> getAdmin();
	void cancellaAdmin(Admin admin);
}
