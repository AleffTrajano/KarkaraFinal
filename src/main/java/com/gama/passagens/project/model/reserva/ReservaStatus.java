package com.gama.passagens.project.model.reserva;

public enum ReservaStatus {
	PP("PENDENTE PAGAMENTO"),
	PG("PAGO"),
	CL("CANCELADA")
	;
	private String descricao;
	private ReservaStatus(String descricao) {
		this.descricao=descricao;
	}
	public String getDescricao() {
		return descricao;
	}
}
