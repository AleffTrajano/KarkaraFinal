package com.gama.passagens.project.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gama.passagens.project.model.reserva.Reserva;

public interface ReservaRepository extends CrudRepository<Reserva, Integer> {
	List<Reserva> findByViajanteIdAndDataHoraBetween(Integer viajanteId, LocalDateTime inicio, LocalDateTime fim );
	
	Reserva findByOrderId(String orderId );
}
