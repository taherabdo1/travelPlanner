package com.crossover.techtrial.java.se.dtos;

import javax.persistence.Column;
import javax.persistence.Embeddable;



@Embeddable
public class Price {
	
	public static enum Currency {
		USD, EUR, AUD, AED
	}
	@Column(name = "currency")
	private Currency currency;
	@Column(name = "price_amount")
	private int amount;

	
	public Price() {
		super();
	}

	public Price(Currency currency, int amount) {
		super();
		this.currency = currency;
		this.amount = amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
