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
@Getter
@NoArgsConstructor
@Table(name = "EMPRESAS")
public class Empresa extends BaseEntity {

	public Empresa(Long id) {
		super(id);
	}

	@Column(name = "tx_nm_fantasia")
	private String nomeFantasia;

	@Column(name = "tx_nm_razao_social")
	private String razaoSocial;
	
	@Column(name = "tx_cnpj")
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
	
}
