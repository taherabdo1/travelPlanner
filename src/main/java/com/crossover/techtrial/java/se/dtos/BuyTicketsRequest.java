package com.crossover.techtrial.java.se.dtos;

public class BuyTicketsRequest {

	private String accountId;
	private boolean sendByMail;
	private int amount;
	private Route route;

	
	public BuyTicketsRequest() {
		super();
	}

	public BuyTicketsRequest(String accountId, int amount, Route route) {
		super();
		this.accountId = accountId;
		this.amount = amount;
		this.route = route;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public boolean isSendByMail() {
		return sendByMail;
	}

	public void setSendByMail(boolean sendByMail) {
		this.sendByMail = sendByMail;
	}

	
}
