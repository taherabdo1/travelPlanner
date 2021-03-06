package com.crossover.techtrial.java.se.repositories;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.crossover.techtrial.java.se.entities.Role;
import com.crossover.techtrial.java.se.entities.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repository;

    Role persistedRole = null;
    @Before
    public void init(){
    	Role role = new Role();
    	role.setName("moderator");
    	persistedRole = entityManager.persist(role);
    	
    }
    @Test
    public void findByEmailTest() {
        entityManager.persist(new User("qwerwew23","hossam@gmail.com", "12345678", persistedRole));
        User user = this.repository.findByEmail("hossam@gmail.com");
        assertEquals(user.getEmail(), "hossam@gmail.com");
    }
    @Test
    public void findByAccountIdTest() {
        entityManager.persist(new User("qwerwew23","hossam@gmail.com", "12345678", persistedRole));
        User user = this.repository.findByAccountId("qwerwew23");
        assertEquals(user.getEmail(), "hossam@gmail.com");
    }
}
