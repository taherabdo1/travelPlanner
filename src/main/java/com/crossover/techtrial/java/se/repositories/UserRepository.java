package com.crossover.techtrial.java.se.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.crossover.techtrial.java.se.entities.User;

@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {

	@Query("Select u  From User u where u.accountId =:accountId")
	User findByAccountId(@Param("accountId") String accountId);

	@Query("Select u  From User u where u.email =:email")
	User findByEmail(@Param("email") String email);
}
