package com.stock.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.stock.model.GenericDAO;
import com.stock.model.dao.helper.LoginDAOHelper;
import com.stock.model.entities.Usuario;
import com.stock.utils.HibernateUtil;

@Repository("loginDAO")
public class LoginDAO extends GenericDAO<Usuario, Long> {

	public LoginDAO() {
		super(Usuario.class);
	}
	
	private static final long serialVersionUID = 4385194662090893131L;

	@Override
	public List<Usuario> findByExample(Usuario entity) {
		Session session = HibernateUtil.openSession(entity);
		Criteria crit = session.createCriteria(super.getClasz()); 
		crit = LoginDAOHelper.getINSTANCE().findByExample(entity, crit);
		
		List<Usuario> result = crit.list(); 
		
		session.close();
		
		return result;
	}

}
