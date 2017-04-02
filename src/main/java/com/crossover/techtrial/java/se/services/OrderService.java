package com.crossover.techtrial.java.se.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crossover.techtrial.java.se.entities.Order;
import com.crossover.techtrial.java.se.repositories.OrderRepository;

@Component
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	public List<Order> getAllOrders(){
		List<Order> orders = (List<Order>) orderRepository.findAll();
		return orders;
	}

}
