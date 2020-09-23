package com.stock.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.stock.model.GenericDAO;

public abstract class GenericService<T, PK extends Serializable> implements Serializable {

	private static final long serialVersionUID = -883914217687470102L;
	
	@Autowired
	private GenericDAO<T, PK> baseDAO;
	
	public void beforeInsert() {}
	
	public void insert(T entity) {
		this.beforeInsert();
		getBaseDAO().insert(entity);
		this.afterInsert();
	}
	
	public void afterInsert() {}
	
	public void beforeDelete() {}
	
	public void delete(T entity) {
		this.beforeDelete();
		getBaseDAO().delete(entity);
		this.afterDelete();
	}
	
	public void afterDelete() {}
	
	public void beforeUpdate() {}
	
	public void update(T entity) {
		this.beforeUpdate();
		getBaseDAO().update(entity);
		this.afterUpdate();
	}
	
	public void afterUpdate() {}
	
	public T findById(Long id) {
		return baseDAO.findById(id);
	}
	
	public List<T> findAll() {
		return baseDAO.findAll();
	}
	
	protected GenericDAO<T, PK> getBaseDAO() {
		return baseDAO;
	}
	
	protected void setBaseDAO(GenericDAO<T, PK> baseDAO) {
		this.baseDAO = baseDAO;
	}
	
}
