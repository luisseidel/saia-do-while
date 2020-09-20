package com.stock.view;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.stock.model.entities.Empresa;
import com.stock.service.services.EmpresaService;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Scope("request")
@Controller("empresaM")
public class EmpresaMBean extends GenericMBean<Empresa, Long> {

	private static final long serialVersionUID = 1223739738744010169L;
	private List<Empresa> list;

	public void action() {
		list = new ArrayList<>();
		
		Empresa e = new Empresa();
		e.setId(1L);
		e.setNomeFantasia("nome fantasia");
		e.setRazaoSocial("razao social");
		e.setCnpj("000 000 000 000 000");
		
		e = getEmpresaService().findById(1L);
		
		list.add(e);
	}
	
	private EmpresaService getEmpresaService() {
		return (EmpresaService) super.getBaseService();
	}
	
	public void setEmpresaService(EmpresaService service) {
		super.setBaseService(service);
	}
	
}
