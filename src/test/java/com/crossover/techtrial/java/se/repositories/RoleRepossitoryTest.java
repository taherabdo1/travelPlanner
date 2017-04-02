package com.crossover.techtrial.java.se.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.crossover.techtrial.java.se.entities.Role;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RoleRepossitoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private RoleRepository roleRepository;

	@Test
	public void findByEmailTest() {
		Role moderatorRole = new Role("Moderator");
		entityManager.persist(moderatorRole);
		Role persistedModeratorRole = roleRepository.findByName("Moderator");
		assertEquals(persistedModeratorRole.getId(), 0);
	}
	
	
}
