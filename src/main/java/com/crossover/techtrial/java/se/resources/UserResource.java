package com.crossover.techtrial.java.se.resources;

import java.security.Principal;
import java.util.List;

import javassist.NotFoundException;

import javax.mail.SendFailedException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crossover.techtrial.java.se.dtos.BuyTicketsRequest;
import com.crossover.techtrial.java.se.entities.Order;
import com.crossover.techtrial.java.se.entities.User;
import com.crossover.techtrial.java.se.exceptions.BadRequestException;
import com.crossover.techtrial.java.se.services.UserService;
import com.crossover.techtrial.java.se.util.SendMail;

@RestController
public class UserResource {

	@Autowired
	HttpSession httpSession;
	@Autowired
	UserService userService;

	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.POST, value = "/buyTicket", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> buyTicket(Principal principal,
			@RequestBody BuyTicketsRequest buyTicketsRequest) {
		try {
			Order newOrder = userService.buyTicket(buyTicketsRequest,
					principal.getName());
			SendMail.sendOrderMail(newOrder);
			return new ResponseEntity<>(newOrder, HttpStatus.OK);
		} catch (BadRequestException b) {
			return new ResponseEntity<>(b.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (NotFoundException nf) {
			return new ResponseEntity<>(nf.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAllPurchasedTickets", produces = "application/json")
	public ResponseEntity<?> getAllPurchasedTickets(Principal principal) {
		try {

			List<Order> tickets = userService.getTickets(principal.getName());
			return new ResponseEntity<>(tickets, HttpStatus.OK);
		} catch (IllegalStateException e) {
			return new ResponseEntity<>("user doesn't has sessionID",
					HttpStatus.UNAUTHORIZED);
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/userSignup", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> userSignUp(@RequestBody User user) {
		User signedUser = userService.signUpUser(user);
		if (signedUser != null) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(signedUser,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAllUsersForAdmin", produces = "application/json")
	public ResponseEntity<?> getAllUsersForAdmin() {
		List<User> users = userService.getUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getUserRole", produces = "application/json")
	public ResponseEntity<?> getUSerRole(Principal principal) {
		User user = userService.getUserRole(principal.getName());
		System.out.println("user email from getUserRole: " + user.getEmail());
		return new ResponseEntity<>(user.getRole(), HttpStatus.OK);
	}

}
