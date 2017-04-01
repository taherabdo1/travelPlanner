package com.crossover.techtrial.java.se.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crossover.techtrial.java.se.dtos.Offer;
import com.crossover.techtrial.java.se.services.OfferService;

@RestController
public class OfferResource {

	@Autowired
	OfferService offerService;

	@RequestMapping(method = RequestMethod.GET, value = "/getAllOffers", produces = "application/json")
	public List<Offer> getAllOffers(){
		return offerService.getAll();
	}
}
