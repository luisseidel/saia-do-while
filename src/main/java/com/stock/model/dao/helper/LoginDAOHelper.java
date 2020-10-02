package com.stock.model.dao.helper;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.stock.model.entities.Usuario;

public class LoginDAOHelper extends GenericDAOHelper<Usuario> {

	private static LoginDAOHelper INSTANCE;
	
	@Override
	public Criteria findByExample(Usuario entity, Criteria crit) {
		
		if (entity.getId() != null)
			crit.add(Restrictions.idEq(entity.getId()));
		
		if (entity.getLogin() != null)
			crit.add(Restrictions.like("login", entity.getLogin()));
		
		if (entity.getPassword() != null)
			crit.add(Restrictions.eq("password", entity.getPassword()));
		
		return crit;
	}
	
	public static LoginDAOHelper getINSTANCE() {
		if (INSTANCE == null)
			INSTANCE = new LoginDAOHelper();
		
		return INSTANCE;
	}

}
