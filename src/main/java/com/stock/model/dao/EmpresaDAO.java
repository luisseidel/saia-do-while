package com.stock.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.stock.model.GenericDAO;
import com.stock.model.dao.helper.EmpresaDAOHelper;
import com.stock.model.entities.Empresa;
import com.stock.utils.HibernateUtil;

@Repository("empresaDAO")
public class EmpresaDAO extends GenericDAO<Empresa, Long> {

	private static final long serialVersionUID = -194350237317689021L;

	public EmpresaDAO() {
		super(Empresa.class);
	}

	public List<Empresa> findByExample(Empresa entity) {
		Session session = HibernateUtil.openSession(entity);
		Criteria crit = session.createCriteria(Empresa.class); 
		crit = EmpresaDAOHelper.queryForFindEmpresaByExample(entity, crit);
		
		return crit.list();
	}

}
