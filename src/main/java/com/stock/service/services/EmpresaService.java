package com.stock.service.services;

import com.stock.model.entities.Empresa;

import org.springframework.stereotype.Service;

import com.stock.model.dao.EmpresaDAO;
import com.stock.service.GenericService;

@Service("empresaService")
public class EmpresaService extends GenericService<Empresa, Long> {

	
	private static final long serialVersionUID = 6641965250693961315L;

	private EmpresaDAO getEmpresaDAO() {
		return (EmpresaDAO) super.getBaseDAO();
	}
	
	public void EmpresaDAO(EmpresaDAO dao) {
		super.setBaseDAO(dao);
	}
	
}
