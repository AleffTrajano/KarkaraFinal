package com.gama.passagens.clientapi.viacep;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Endereco {
	@JsonProperty("cep")
	private String codigoPostal;
	private String logradouro;
	private String complemento;
	
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
}
