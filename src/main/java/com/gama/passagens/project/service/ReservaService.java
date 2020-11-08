package com.gama.passagens.project.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gama.karkara.model.pagamento.PagarmeService;
import com.gama.passagens.amadeus.order.FlightOrderService;
import com.gama.passagens.amadeus.order.Order;
import com.gama.passagens.infra.exceptions.BusinessException;
import com.gama.passagens.infra.exceptions.EmailExistenteException;
import com.gama.passagens.project.model.cadastro.Viajante;
import com.gama.passagens.project.model.dto.ViajanteReserva;
import com.gama.passagens.project.model.reserva.Reserva;
import com.gama.passagens.project.model.reserva.ReservaStatus;
import com.gama.passagens.project.repository.ReservaRepository;
import com.gama.passagens.project.repository.ViajanteRepository;

import me.pagar.model.PagarMeException;
import me.pagar.model.Transaction;
import me.pagar.model.Transaction.Status;

@Component
public class ReservaService {
	@Autowired
	private FlightOrderService orderService;
	
	@Autowired
	private ViajanteRepository viajanteRepository;
	
	@Autowired
	private ReservaRepository repository;
	
	@Autowired
	private PagarmeService pagService;
	
	public void testeException() {
		throw new EmailExistenteException("Já existe um usuário com o email " + " email@email.com" );
	}
	
	public String createOrder(Integer viajanteId, String json) {
		Order postOrder = orderService.postOrder(json);
		
		if(postOrder.getId()!=null) {
			Reserva r = new Reserva();
			r.setOrderId(postOrder.getId());
			r.setPrice(postOrder.getPrice());
			r.setViajanteId(viajanteId);
			repository.save(r);
		}
		return postOrder.getJson();
	}
	public ViajanteReserva viajanteReservas(Integer viajanteId, LocalDateTime inicio, LocalDateTime fim) {
		ViajanteReserva detalhe = new ViajanteReserva();
		Optional <Viajante> viajante = viajanteRepository.findById(viajanteId);
		detalhe.setViajante(viajante.get());
		detalhe.setReservas(listarReservas(viajanteId, inicio, fim));
		return detalhe;
		
	}
	private List<Reserva> listarReservas(Integer viajanteId, LocalDateTime inicio, LocalDateTime fim) {
		
		List<Reserva> findByDataHoraBetween = repository.findByViajanteIdAndDataHoraBetween(viajanteId, inicio, fim);
		return findByDataHoraBetween;
	}
	
	public void confirmarPagamento(String orderId) {
		Reserva reserva = repository.findByOrderId(orderId);
		try {
			if(reserva!=null) {
				Transaction ts = pagService.criarTransacao();
				if(ts.getStatus()== Status.REFUSED) {
					reserva.setIdPagamento(ts.getId());
					reserva.setStatus(ReservaStatus.PG);
					repository.save(reserva);
				}
				
			}
		} catch (PagarMeException e) {
			e.printStackTrace();
		}
	}
}
