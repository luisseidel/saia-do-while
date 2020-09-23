package com.stock.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@NoArgsConstructor
@Table(name = "EMPRESAS")
public class Empresa extends BaseEntity {

	public Empresa(Long id) {
		super(id);
	}

	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;
	
	@Id
	@Override
	@Column(name = "id_empresa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return super.getId();
	}
	
	@Override
	public void setId(Long id) {
		super.setId(id);
	}
	
	@Column(name = "nm_fantasia")
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	
	@Column(name = "nm_razao_social")
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	@Column(name = "tx_cnpj")
	public String getCnpj() {
		return cnpj;
	}
	
}
