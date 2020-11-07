package com.gama.passagens.amadeus.flight;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.resources.FlightOfferSearch;
import com.google.gson.Gson;

@Service
public class FlightSearchService {
	@Autowired
	private Amadeus amadeus;
	
	public FlightSearch flights(Map<String,String> params) throws Exception {
		String body = body(params);
		FlightSearch response = converter(body);
		return response;
	}
	private FlightSearch converter(String json) throws Exception {
		Gson gson = new Gson();
		FlightSearch root = gson.fromJson(json, FlightSearch.class);
		return root;
	}
	
	private String body(Map<String,String> params) throws Exception{
		Params p = null;
		for(Map.Entry<String, String> entry : params.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    if(p==null)
		    	p= Params.with(key, value);
		    else
		    	p.and(key, value);
		}
		FlightOfferSearch[] flightOffersSearches = amadeus.shopping.flightOffersSearch.get(p);
		return flightOffersSearches[0].getResponse().getBody();
	}
}
