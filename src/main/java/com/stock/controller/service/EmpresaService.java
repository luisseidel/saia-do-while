package com.stock.controller.service;

import org.springframework.stereotype.Service;

import com.stock.controller.GenericService;
import com.stock.model.dao.EmpresaDAO;
import com.stock.model.entities.Empresa;

@Service("empresaService")
public class EmpresaService extends GenericService<Empresa, Long> {
	
	private static final long serialVersionUID = 6641965250693961315L;

	private EmpresaDAO getEmpresaDAO() {
		return (EmpresaDAO) super.getBaseDAO();
	}
	
	public void setEmpresaDAO(EmpresaDAO dao) {
		super.setBaseDAO(dao);
	}
	
}
