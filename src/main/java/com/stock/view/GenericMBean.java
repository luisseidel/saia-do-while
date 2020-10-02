package com.stock.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.stock.controller.GenericService;

public abstract class GenericMBean<T, PK extends Serializable> implements Serializable {

	private static final long serialVersionUID = -711539006944368718L;
	
	protected List<T> list;
	
	@Autowired
	private GenericService<T, PK> baseService;

	
	@PostConstruct
	public void init() {}
	
	public void beforeSearch() {}
	
	public void search(T entitySearch) {
		this.beforeSearch();
		list = baseService.findByExample(entitySearch);
		this.afterSearch();
	}
	
	public void afterSearch() {}
	
	public String insert() {
		return "edit.xhtml";
	}
	
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
	
}
