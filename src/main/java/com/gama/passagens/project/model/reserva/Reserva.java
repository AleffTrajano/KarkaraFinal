package com.gama.passagens.project.model.reserva;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_reserva")
public class Reserva {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String orderId;
	
	private BigDecimal price;
	
	@Column(name = "viajante_id")
	private Integer viajanteId;
	
	@Column(name = "dh_reserva")
	private LocalDateTime dataHora = LocalDateTime.now();
	
	@Enumerated(EnumType.STRING)
	private ReservaStatus status = ReservaStatus.PP;
	
	@Column(name = "id_pagamento")
	private Integer idPagamento;
	
	public Integer getIdPagamento() {
		return idPagamento;
	}
	public void setIdPagamento(Integer idPagamento) {
		this.idPagamento = idPagamento;
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getViajanteId() {
		return viajanteId;
	}
	public void setViajanteId(Integer viajanteId) {
		this.viajanteId = viajanteId;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public ReservaStatus getStatus() {
		return status;
	}
	public void setStatus(ReservaStatus status) {
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	
	
}
