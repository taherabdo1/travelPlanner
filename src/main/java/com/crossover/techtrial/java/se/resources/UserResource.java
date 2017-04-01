package com.crossover.techtrial.java.se.resources;

import java.util.List;

import javassist.NotFoundException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crossover.techtrial.java.se.dtos.BuyTicketsRequest;
import com.crossover.techtrial.java.se.entities.Order;
import com.crossover.techtrial.java.se.entities.User;
import com.crossover.techtrial.java.se.exceptions.BadRequestException;
import com.crossover.techtrial.java.se.services.UserService;

@RestController
public class UserResource {

	@Autowired
	HttpSession httpSession;
	@Autowired
	UserService userService;

	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.POST, value = "/buyTicket", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> buyTicket(
			@RequestBody BuyTicketsRequest buyTicketsRequest) {
		// to be activated after adding login
		// buyTicketsRequest.setAccountId((String)httpSession.getAttribute("accountId"));
		try {
			Order newOrder = userService.buyTicket(buyTicketsRequest);
			try {
				List<Order> tickets = (List<Order>) httpSession
						.getAttribute("purchaseTickets");
				tickets.add(newOrder);
			} catch (IllegalStateException e) {
				return new ResponseEntity<>("user doesn't has sessionID",
						HttpStatus.UNAUTHORIZED);
			}
			return new ResponseEntity<>(newOrder, HttpStatus.OK);
		} catch (BadRequestException b) {
			return new ResponseEntity<>(b.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (NotFoundException nf) {
			return new ResponseEntity<>(nf.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAllPurchasedTickets", produces = "application/json")
	public ResponseEntity<?> getAllPurchasedTickets(
			@RequestParam(value = "accountId") String accountId) {
		try {
			List<Order> tickets = userService.getTickets(accountId);
			return new ResponseEntity<>(tickets, HttpStatus.OK);
		} catch (IllegalStateException e) {
			return new ResponseEntity<>("user doesn't has sessionID",
					HttpStatus.UNAUTHORIZED);
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/signup", consumes = "application/json")
	public ResponseEntity<?> userSignUp(@RequestBody User user) {
		User signedUser = userService.signUpUser(user);
		if (signedUser != null) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(signedUser,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
