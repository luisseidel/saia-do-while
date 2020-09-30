package com.stock.view;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.stock.controller.service.EmpresaService;
import com.stock.model.entities.Empresa;
import com.stock.utils.MessageUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Scope("request")
@Controller("empresaM")
public class EmpresaMBean extends GenericMBean<Empresa, Long> {

	private static final long serialVersionUID = 1223739738744010169L;
	private Empresa entitySearch;
	
	@Override
	public void init() {
		super.init();
		entitySearch = new Empresa();
	}

	public void find() {
		super.list = getEmpresaService().findByExample(entitySearch);
		MessageUtils.infoMessage("msg_insert");
		MessageUtils.fatalMessage("msg_insert");
	}
	
	private EmpresaService getEmpresaService() {
		return (EmpresaService) super.getBaseService();
	}
	
	public void setEmpresaService(EmpresaService service) {
		super.setBaseService(service);
	}
	
}
