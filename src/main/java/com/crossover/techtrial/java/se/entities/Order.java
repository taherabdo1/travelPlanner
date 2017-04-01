package com.crossover.techtrial.java.se.entities;

import java.io.Serializable;

import javax.persistence.*;

import com.crossover.techtrial.java.se.dtos.Price;
import com.crossover.techtrial.java.se.dtos.Route;
import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name = "orders")
@NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int amount;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "amount", column = @Column(name = "price_amount")),
			@AttributeOverride(name = "currency", column = @Column(name = "currency")) })
	private Price price;
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "from", column = @Column(name = "from_city")),
			@AttributeOverride(name = "to", column = @Column(name = "to_city")) })
	private Route route;
//	private String from;

	@Column(name = "is_done")
	private boolean isDone;

//	private String to;

	// bi-directional many-to-one association to User
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "account_id")
	private User user;

	public Order() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean getIsDone() {
		return this.isDone;
	}

	public void setIsDone(boolean isDone) {
		this.isDone = isDone;
	}
	
	public User getUser() {
		return this.user;
	}


	public void setUser(User user) {
		this.user = user;
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

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	
	

}