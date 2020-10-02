package com.stock.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.stock.model.GenericDAO;
import com.stock.utils.MessageUtils;

public abstract class GenericService<T, PK extends Serializable> implements Serializable {

	private static final long serialVersionUID = -883914217687470102L;
	
	@Autowired
	private GenericDAO<T, PK> baseDAO;
	
	public void beforeInsert() {}
	
	public void insert(T entity) {
		this.beforeInsert();
		getBaseDAO().insert(entity);
		MessageUtils.insertMessage();
		this.afterInsert();
	}
	
	public void afterInsert() {}
	
	public void beforeDelete() {}
	
	public void delete(T entity) {
		this.beforeDelete();
		getBaseDAO().delete(entity);
		MessageUtils.deleteMessage();
		this.afterDelete();
	}
	
	public void afterDelete() {}
	
	public void beforeUpdate() {}
	
	public void update(T entity) {
		this.beforeUpdate();
		getBaseDAO().update(entity);
		MessageUtils.updateMessage();
		this.afterUpdate();
	}
	
	public void afterUpdate() {}
	
	public T findById(Long id) {
		return baseDAO.findById(id);
	}
	
	public List<T> findByExample(T entity) {
		return getBaseDAO().findByExample(entity);
	}
	
	protected GenericDAO<T, PK> getBaseDAO() {
		return baseDAO;
	}
	
	protected void setBaseDAO(GenericDAO<T, PK> baseDAO) {
		this.baseDAO = baseDAO;
	}
	
}
