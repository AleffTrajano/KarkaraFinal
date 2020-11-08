package com.gama.karkara.model.pagamento;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class DadosPagamento {

	@NotNull(message = "O n�mero do pedido deve ser preenchido")
	private Integer numPedido;
	@Valid
	private DadosCartao dadosCartao;
	@NotNull(message = "O valor cobrado deve ser preenchido")
	private Integer valorCobrado;

	public Integer getValorCobrado() {
		return valorCobrado;
	}

	public void setValorCobrado(Integer valorCobrado) {
		this.valorCobrado = valorCobrado;
	}

	public Integer getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(Integer numPedido) {
		this.numPedido = numPedido;
	}

	public DadosCartao getDadosCartao() {
		return dadosCartao;
	}

	public void setDadosCartao(DadosCartao dadosCartao) {
		this.dadosCartao = dadosCartao;
	}

}
