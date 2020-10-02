package com.stock.view;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.stock.controller.service.LoginService;
import com.stock.model.entities.Usuario;
import com.stock.utils.MessageUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Scope("request")
@Controller("loginM")
public class LoginMBean extends GenericMBean<Usuario, Long> {

	private static final long serialVersionUID = -9142204725629077897L;
	private Usuario entitySearch;
	
	@Override
	public void init() {
		super.init();
		entitySearch = new Usuario();
	}
	
	public String login() {
		
		if (StringUtils.isEmpty(getEntitySearch().getLogin()))
			MessageUtils.errorMessage("login_obrigatorio");
		
		if (StringUtils.isEmpty(getEntitySearch().getPassword()))
			MessageUtils.errorMessage("senha_obrigatorio");
		
		List<Usuario> list = getLoginService().findByExample(entitySearch);
		
		if (CollectionUtils.isEmpty(list) || list.size() > 1) {
			MessageUtils.errorMessage("login_senha_incorretos");
		} else {
			MessageUtils.infoMessage("bem_vindo");
		}
		
		return "./cadastroEmpresas/list.xhtml";
	}
	
	public LoginService getLoginService() {
		return (LoginService) super.getBaseService();
	}
	
	public void setLoginService(LoginService service) {
		super.setBaseService(service);
	}

}
