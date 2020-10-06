package com.stock.view;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.stock.controller.service.EmpresaService;
import com.stock.model.entities.Empresa;
import com.stock.stockException.StockException;
import com.stock.utils.ValidationUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Scope("request")
@Controller("empresaM")
public class EmpresaMBean extends GenericMBean<Empresa, Long> {

	private static final long serialVersionUID = 1223739738744010169L;
	
	
	@Override
	public void init() {
		super.init();
		super.entitySearch = new Empresa();
		super.entity = new Empresa();
	}
	
	@Override
	public void beforeSearch() {
		super.beforeSearch();
		
		try {
			if (!ValidationUtils.validateCNPJ(entitySearch.getCnpj())) {
				throw new StockException("cnpj_invalido"); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private EmpresaService getEmpresaService() {
		return (EmpresaService) super.getBaseService();
	}
	
	public void setEmpresaService(EmpresaService service) {
		super.setBaseService(service);
	}

}
