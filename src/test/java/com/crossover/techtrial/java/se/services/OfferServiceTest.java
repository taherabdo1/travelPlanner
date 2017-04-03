package com.crossover.techtrial.java.se.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.crossover.techtrial.java.se.dtos.Offer;
import com.crossover.techtrial.java.se.dtos.Price;
import com.crossover.techtrial.java.se.dtos.Price.Currency;
import com.crossover.techtrial.java.se.dtos.Route;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class OfferServiceTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@MockBean
	private OfferService offerService;

	@Before
    public void setup() {
		List<Offer> offers = new ArrayList<>();
    	Offer offer = new Offer(new Route("cairo", "giza"), new Price(Currency.AED, 120));
    	offers.add(offer);
    	
        Mockito.when(this.offerService.getAll()).thenReturn(offers);
    }
	@Test
	public void testGatAll() {
		List<Offer> returnedOffers = offerService.getAll();
		System.out.println("offers size: " + returnedOffers.size());
		Assert.assertEquals(returnedOffers.size(), 1);

	}
}
