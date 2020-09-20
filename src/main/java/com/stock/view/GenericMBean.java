package com.stock.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.stock.service.GenericService;

public abstract class GenericMBean<T, PK extends Serializable> implements Serializable {

	private static final long serialVersionUID = -711539006944368718L;
	
	@Autowired
	private GenericService<T, PK> baseService;

	@PostConstruct
	public void init() {
	}
	
	public GenericService<T, PK> getBaseService() {
		return baseService;
	}
	
	public void setBaseService(GenericService<T, PK> baseService) {
		this.baseService = baseService;
	}
	
}
