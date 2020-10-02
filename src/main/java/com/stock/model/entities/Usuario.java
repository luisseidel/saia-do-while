package com.stock.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Entity
@NoArgsConstructor
@Table(name = "USUARIOS")
public class Usuario extends BaseEntity {

	private String login;
	private String password;

	public Usuario(Long id) {
		super(id);
	}
	
	@Id
	@Override
	@Column(name = "id_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return super.getId();
	}
	
	@Override
	public void setId(Long id) {
		super.setId(id);
	}
	
	
	@Column(name = "tx_login")
	public String getLogin() {
		return login;
	}
	
	@Column(name = "tx_password")
	public String getPassword() {
		return password;
	}
	
}
