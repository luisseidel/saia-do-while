package com.stock.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.stock.controller.GenericService;
import com.stock.model.entities.BaseEntity;
import com.stock.model.type.TransactionType;

public abstract class GenericMBean<T, PK extends Serializable> implements Serializable {

	private static final long serialVersionUID = -711539006944368718L;
	
	protected List<T> list;
	protected T entitySearch;
	protected T entity;
	protected TransactionType transaction;
	
	@Autowired
	private GenericService<T, PK> baseService;

	
	@PostConstruct
	public void init() {
		this.transaction = TransactionType.SEARCH;
	}
	
	public void defaultValuesForSearch() {}
	
	public void beforeSearch() {}
	
	public void search() {
		this.defaultValuesForInsert();
		this.beforeSearch();
		list = baseService.findByExample(entitySearch);
		this.afterSearch();
	}
	
	public void afterSearch() {}
	
	public void defaultValuesForInsert() {}
	
	public String goInsert() {
		this.transaction = TransactionType.INSERT;
		this.defaultValuesForInsert();
		return transaction.getScreen();
	}
	
	public String voltarLista() {
		this.transaction = TransactionType.SEARCH;
		return transaction.getScreen();
	}
	
	public void beforePersist() {}
	
	public void persist() {
		this.beforePersist();
		
		if (getTransaction() == TransactionType.INSERT) {
			getBaseService().insert(this.entity);
		} else {
			getBaseService().update(this.entity);
		}
}
	
	public String edit(BaseEntity entity) {
		transaction = TransactionType.UPDATE;
		this.entity = getBaseService().findById(entity.getId());
		
		return transaction.getScreen();
	};
	
	public void delete(T entity) {
		transaction = TransactionType.DELETE;
		getBaseService().delete(entity);
	}
	
	/** Getters && Setters **/
	
	public GenericService<T, PK> getBaseService() {
		return baseService;
	}
	
	public void setBaseService(GenericService<T, PK> baseService) {
		this.baseService = baseService;
	}
	
	public List<T> getList() {
		return list;
	}
	
	public void setList(List<T> list) {
		this.list = list;
	}
	
	public T getEntity() {
		return entity;
	}
	
	public void setEntity(T entity) {
		this.entity = entity;
	}
	
	public T getEntitySearch() {
		return entitySearch;
	}
	
	public void setEntitySearch(T entitySearch) {
		this.entitySearch = entitySearch;
	}
	
	public TransactionType getTransaction() {
		return transaction;
	}
	
	public void setTransaction(TransactionType transaction) {
		this.transaction = transaction;
	}
}
