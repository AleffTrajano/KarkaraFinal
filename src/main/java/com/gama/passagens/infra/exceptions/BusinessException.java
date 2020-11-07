package com.gama.passagens.infra.exceptions;

public  class BusinessException extends RuntimeException {
	public static String ERROR_ID = "400";
	private String tipo;
	private String codigo;
	private String mensagem;
	public BusinessException(String tipo, String codigo, String mensagem) {
		super(mensagem);
		this.tipo = tipo;
		this.codigo = codigo;
		this.mensagem = mensagem;
	}
	public BusinessException(String mensagem) {
		this("400","999",mensagem);
	}
	public String getTipo() {
		return tipo;
	}
	public String getCodigo() {
		return codigo;
	}
	public String getMensagem() {
		return mensagem;
	}
}