package com.stock.model.dao;

import org.springframework.stereotype.Repository;

import com.stock.model.GenericDAO;
import com.stock.model.entities.Empresa;

@Repository("empresaDAO")
public class EmpresaDAO extends GenericDAO<Empresa, Long> {

	private static final long serialVersionUID = -194350237317689021L;

	public EmpresaDAO() {
		super(Empresa.class);
	}

}
