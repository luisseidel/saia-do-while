package com.stock.controller.service;

import org.springframework.stereotype.Service;

import com.stock.controller.GenericService;
import com.stock.model.dao.LoginDAO;
import com.stock.model.entities.Usuario;

@Service("loginService")
public class LoginService extends GenericService<Usuario, Long> {

	private static final long serialVersionUID = -2596672194235259253L;
	
	public LoginDAO getLoginDAO() {
		return (LoginDAO) super.getBaseDAO();
	}
	
	public void setLoginDAO(LoginDAO dao) {
		super.setBaseDAO(dao);
	}

}
