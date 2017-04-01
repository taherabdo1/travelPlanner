package com.crossover.techtrial.java.se.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.crossover.techtrial.java.se.entities.Role;

@Transactional
public interface RoleRepository extends CrudRepository<Role, Integer> {

	@Query("Select r From Role r where r.name = :name")
	Role findByName(@Param("name") String name);
}
