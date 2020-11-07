package com.gama.passagens.infra.exceptions;

public class EmailExistenteException extends BusinessException {
	public EmailExistenteException(String mensagem) {
		super(ERROR_ID,"001",mensagem);
	}

}
