package com.crossover.techtrial.java.se.dtos;

public class Ticket {

	private TicketDetails details;
	private int amount;

	public Ticket() {
		super();
	}

	public Ticket(TicketDetails details, int amount) {
		super();
		this.details = details;
		this.amount = amount;
	}

	public TicketDetails getDetails() {
		return details;
	}

	public void setDetails(TicketDetails details) {
		this.details = details;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
