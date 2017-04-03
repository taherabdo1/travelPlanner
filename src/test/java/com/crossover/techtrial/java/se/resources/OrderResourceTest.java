package com.crossover.techtrial.java.se.resources;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.crossover.techtrial.java.se.dtos.BuyTicketsRequest;
import com.crossover.techtrial.java.se.dtos.Offer;
import com.crossover.techtrial.java.se.dtos.Price;
import com.crossover.techtrial.java.se.dtos.Route;
import com.crossover.techtrial.java.se.dtos.Price.Currency;
import com.crossover.techtrial.java.se.entities.Order;
import com.crossover.techtrial.java.se.entities.Role;
import com.crossover.techtrial.java.se.entities.User;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class OrderResourceTest {

//	@Autowired
	private TestRestTemplate restTemplate;

//	@MockBean
	private OrderResource orderResource;

//	@Before
	public void setup() {
		List<Order> orders = new ArrayList<>();
		Order order1 = new Order();
		order1.setAmount(1);
		order1.setDone(true);
		order1.setId(1);
		order1.setPrice(new Price(Currency.AED, 120));
		order1.setRoute(new Route("cairo", "giza"));
		order1.setUser(new User("acount1", "test1@gmail.com", "123451234",
				new Role("Moderator")));
		Order order2 = new Order();
		order2.setAmount(1);
		order2.setDone(true);
		order2.setId(2);
		order2.setPrice(new Price(Currency.AED, 120));
		order2.setRoute(new Route("giza", "cairo"));
		order2.setUser(new User("acount1", "test2@gmail.com", "123451234",
				new Role("Moderator")));
		orders.add(order1);
		orders.add(order2);
		Mockito.when(this.orderResource.getAllPurchasedTickets()).thenReturn(
				new ResponseEntity(orders, HttpStatus.OK));
	}

//	@Test
	public void testGatAll() {
	}
}
