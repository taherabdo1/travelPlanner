package com.crossover.techtrial.java.se.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crossover.techtrial.java.se.entities.Order;
import com.crossover.techtrial.java.se.services.OrderService;

@RestController
public class OrderResource {

	@Autowired
	OrderService orderService;

	@RequestMapping(method = RequestMethod.GET, value = "/getAllOrdersForAdmin", produces = "application/json")
	public ResponseEntity<?> getAllPurchasedTickets() {
		List<Order> orders = orderService.getAllOrders();
		return new ResponseEntity<>(orders, HttpStatus.OK);

	}
}
