package com.gama.passagens.amadeus.order;

import java.util.List;

import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.Traveler;

public class FlightOrderRequestData {
	private List<FlightOfferSearch>flightOffers;
	private List<Traveler> travelers;
	public List<FlightOfferSearch> getFlightOffers() {
		return flightOffers;
	}
	public void setFlightOffers(List<FlightOfferSearch> flightOffers) {
		this.flightOffers = flightOffers;
	}
	public List<Traveler> getTravelers() {
		return travelers;
	}
	public void setTravelers(List<Traveler> travelers) {
		this.travelers = travelers;
	}
}
