package com.gama.passagens.project.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gama.passagens.amadeus.flight.FlightSearch;
import com.gama.passagens.amadeus.flight.FlightSearchService;
import com.gama.passagens.project.service.ReservaService;

@RestController
@RequestMapping("/flights")
public class FlightController {
	
	@Autowired
	private FlightSearchService flightSearchService;
	
	@Autowired
	private ReservaService service;
	
	
	@PostMapping("")
	public FlightSearch flights(@RequestBody Map<String,String> params) {
		try {
			return flightSearchService.flights(params);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    	
	}
	@PostMapping("/order/{viajante}")
	public String postOrder(@PathVariable("viajante") Integer viajante, @RequestBody String order) {
		return service.createOrder(viajante,order);
	}
	/*
	@GetMapping("/order/get")
	public String getOrder(@RequestParam("id") String id ) {
		return orderService.getOrder(id);
	}
	*/
}
