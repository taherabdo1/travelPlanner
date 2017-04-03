package com.crossover.techtrial.java.se.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.crossover.techtrial.java.se.dtos.Price;
import com.crossover.techtrial.java.se.dtos.Price.Currency;
import com.crossover.techtrial.java.se.dtos.Route;
import com.crossover.techtrial.java.se.entities.Order;
import com.crossover.techtrial.java.se.entities.Role;
import com.crossover.techtrial.java.se.entities.User;

public class OrderServiceTest {

	@MockBean
	private OrderService orderService;

	@Before
	public void setUp() {
		Order order1 = new Order();
		order1.setAmount(1);
		order1.setDone(true);
		order1.setId(1);
		order1.setPrice(new Price(Currency.AED, 120));
		order1.setRoute(new Route("cairo", "giza"));
		order1.setUser(new User("acount1", "test1@gmail.com", "123451234",
				new Role("Moderator")));
		List<Order> orders = new ArrayList<>();
		orders.add(order1);
		Mockito.when(orderService.getAllOrders()).thenReturn(orders);

	}

//	@Test
	public void testGatAll() {
		List<Order> returnedOrders = orderService.getAllOrders();
		Assert.assertNotEquals(returnedOrders.size(), 0);
	}

}