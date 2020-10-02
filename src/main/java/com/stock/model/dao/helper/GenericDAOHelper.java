package com.stock.model.dao.helper;

import org.hibernate.Criteria;

public abstract class GenericDAOHelper<T> {

	public abstract Criteria findByExample(T entity, Criteria crit);
	
}
