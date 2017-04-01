package com.crossover.techtrial.java.se.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.crossover.techtrial.java.se.entities.Order;

@Transactional
public interface OrderRepository extends CrudRepository<Order, Integer> {

	@Query("Select o From Order o where o.user.accountId = :accountId")
	List<Order> findAllForAnAccount(@Param("accountId")String accountId);
}
