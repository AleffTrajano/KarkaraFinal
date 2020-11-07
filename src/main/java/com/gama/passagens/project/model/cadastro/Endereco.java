package com.gama.passagens.project.model.cadastro;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
	private String logradouro;
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
}
