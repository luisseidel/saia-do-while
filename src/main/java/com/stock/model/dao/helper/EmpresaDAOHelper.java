package com.stock.model.dao.helper;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.stock.model.entities.Empresa;

public class EmpresaDAOHelper {

	public static Criteria queryForFindEmpresaByExample(Empresa entity, Criteria crit) {
		
		if (entity.getId() != null)
			crit.add(Restrictions.idEq(entity.getId()));
		
		if (StringUtils.isNotEmpty(entity.getNomeFantasia()))
			crit.add(Restrictions.like("nomeFantasia", entity.getNomeFantasia()));
		
		if (StringUtils.isNotEmpty(entity.getRazaoSocial()))
			crit.add(Restrictions.like("razaoSocial", entity.getRazaoSocial()));
		
		if (StringUtils.isNotEmpty(entity.getCnpj()))
			crit.add(Restrictions.like("cnpj", entity.getCnpj()));
		
		return crit;
		
	}
	
}
