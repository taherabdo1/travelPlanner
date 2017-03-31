package com.crossover.techtrial.java.se.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.crossover.techtrial.java.se.entities.Role;

@Transactional
public interface RoleRepository extends CrudRepository<Role, Integer> {

}
