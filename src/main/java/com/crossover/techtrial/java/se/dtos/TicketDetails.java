package com.crossover.techtrial.java.se.dtos;

public class TicketDetails {

	Route route;
	Price price;

	public TicketDetails() {
		super();
	}

	public TicketDetails(Route route, Price price) {
		super();
		this.route = route;
		this.price = price;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

}
