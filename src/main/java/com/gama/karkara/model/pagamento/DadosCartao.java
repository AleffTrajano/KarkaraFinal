package com.gama.karkara.model.pagamento;

import javax.validation.constraints.NotNull;


public class DadosCartao {

	@NotNull(message = "O nome do titular deve ser preenchido")
	private String nomeTitular;
	@NotNull(message = "O n�mero do cart�o deve ser preenchido")
	private String numeroCartao;
	@NotNull(message = "O c�digo de seguran�a do cart�o deve ser preenchido")
	private String cvvCartao;
	@NotNull(message = "A data de expira��o do cart�o deve ser preenchida")
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
