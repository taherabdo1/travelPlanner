package com.crossover.techtrial.java.se.dtos;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Route {

	@Column(name = "from_city")
	String from;
	@Column(name = "to_city")
	String to;

	public Route() {
		super();
	}

	public Route(String from, String to) {
		super();
		this.from = from;
		this.to = to;
	}

	public String getfrom() {
		return from;
	}

	public void setfrom(String from) {
		this.from = from;
	}

	public String getto() {
		return to;
	}

	public void setto(String to) {
		this.to = to;
	}

}
