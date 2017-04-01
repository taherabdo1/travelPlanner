package com.crossover.techtrial.java.se.services;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.crossover.techtrial.java.se.dtos.Offer;

@Component
public class OfferService {

	public List<Offer> getAll(){
	    RestTemplate restTemplate = new RestTemplate();
        List<Offer> offers = restTemplate.getForObject("https://api-forest.crossover.com/Gl63W2y/gammaairlines/offers", List.class);
        return offers;
	}
}
