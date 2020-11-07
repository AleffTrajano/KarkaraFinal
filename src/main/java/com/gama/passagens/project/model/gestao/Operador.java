package com.gama.passagens.project.model.gestao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.gama.passagens.project.model.acesso.Usuario;

@Entity
@Table(name = "tab_operador")
public class Operador extends Usuario {
	
	@Column(length = 60)
	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
