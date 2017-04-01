package com.crossover.techtrial.java.se.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javassist.NotFoundException;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.crossover.techtrial.java.se.dtos.BuyTicketsRequest;
import com.crossover.techtrial.java.se.dtos.Ticket;
import com.crossover.techtrial.java.se.dtos.Price;
import com.crossover.techtrial.java.se.dtos.Route;
import com.crossover.techtrial.java.se.entities.Order;
import com.crossover.techtrial.java.se.entities.User;
import com.crossover.techtrial.java.se.exceptions.BadRequestException;
import com.crossover.techtrial.java.se.repositories.OrderRepository;
import com.crossover.techtrial.java.se.repositories.UserRepository;

@Component
public class UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	OrderRepository orderRepository;

	public Order buyTicket(BuyTicketsRequest buyTicketsRequest)
			throws BadRequestException, NotFoundException {
		System.out.println("the order from service layer is: "
				+ buyTicketsRequest.getAccountId());
		User user = userRepository.findByAccountId("wew");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Ticket> response = restTemplate
				.postForEntity(
						"https://api-forest.crossover.com/Gl63W2y/gammaairlines/tickets/buy",
						buyTicketsRequest, Ticket.class);
		Ticket orderFromCrossOverAPI = response.getBody();
		System.out.println("order from crossover amount: "
				+ orderFromCrossOverAPI.getAmount());
		// CrossOverOrder orderFromCrossOverAPI = restTemplate
		// .postForObject(
		// "https://api-forest.crossover.com/Gl63W2y/gammaairlines/tickets/buy",
		// buyTicketsRequest, CrossOverOrder.class);
		if (response.getStatusCode().value() == 200) {
			Order order = new Order();
			order.setAmount(orderFromCrossOverAPI.getAmount());
			order.setIsDone(true);
			order.setRoute(new Route(orderFromCrossOverAPI.getDetails()
					.getRoute().getfrom(), orderFromCrossOverAPI.getDetails()
					.getRoute().getto()));
			order.setPrice(new Price(orderFromCrossOverAPI.getDetails()
					.getPrice().getCurrency(), orderFromCrossOverAPI
					.getDetails().getPrice().getAmount()));
			order.setUser(user);
			orderRepository.save(order);
			// add the new order to the orders in the session to used if user
			// asked for report
			return order;
		} else if (response.getStatusCode().value() == 400) {
			throw new BadRequestException(
					"Amount not valid or insufficient funds in your account");
		} else if (response.getStatusCode().value() == 404) {
			throw new NotFoundException(
					"Applicant, airline route or account not found");
		}
		return null;
	}

	public List<Order> getTickets(String accountId) {
		System.out.println("account Id : " + accountId);
		List<Order> orders = (List<Order>) orderRepository.findAllForAnAccount(accountId);

		// ResponseEntity<List> response = restTemplate
		// .getForEntity(
		// "https://api-forest.crossover.com/Gl63W2y/gammaairlines/tickets",
		// List.class, vars);
		// List<Ticket> orders = (List<Ticket>) response.getBody();
		return orders;

	}
}