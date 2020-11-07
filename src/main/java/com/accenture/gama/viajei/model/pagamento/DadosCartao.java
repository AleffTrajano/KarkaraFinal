package com.accenture.gama.viajei.model.pagamento;

import javax.validation.constraints.NotNull;


public class DadosCartao {

	@NotNull(message = "O nome do titular deve ser preenchido")
	private String nomeTitular;
	@NotNull(message = "O número do cartão deve ser preenchido")
	private String numeroCartao;
	@NotNull(message = "O código de segurança do cartão deve ser preenchido")
	private String cvvCartao;
	@NotNull(message = "A data de expiração do cartão deve ser preenchida")
	private String dataExpiracao;

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getCvvCartao() {
		return cvvCartao;
	}

	public void setCvvCartao(String cvvCartao) {
		this.cvvCartao = cvvCartao;
	}

	public String getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(String dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

}
