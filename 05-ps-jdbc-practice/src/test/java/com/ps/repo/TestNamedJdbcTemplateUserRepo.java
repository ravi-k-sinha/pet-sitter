package com.ps.repo;

import com.ps.config.AppConfig;
import com.ps.config.TestDataConfig;
import com.ps.ents.User;
import com.ps.repos.UserRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by iuliana.cosmina on 6/4/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDataConfig.class, AppConfig.class})
@ActiveProfiles("dev")
// TODO 30. [BONUS] Write test methods to cover all methods in JdbcNamedTemplateUserRepo
public class TestNamedJdbcTemplateUserRepo {

    @Autowired
    @Qualifier("userNamedTemplateRepo")
    UserRepo userRepo;

    @Before
    public void setUp() {
        assertNotNull(userRepo);
    }

    @Test
    public void testFindById() {
        User user = userRepo.findById(1L);
        assertEquals("John", user.getUsername());
    }

    @Test
    public void testNoFindById() {
        User user = userRepo.findById(99L);
        assertEquals("John", user.getUsername());
    }

    @Test
    public void testCreateUser() {
        int result = userRepo.createUser(11L, "NewUser", "NewPassword", "newemail@old.com");
        assertEquals(1, result);
    }

    @Test
    public void testDeleteById() {
        // TODO 30:2

        int existing = userRepo.findAll().size();
        assertEquals(4, existing);

        int result = userRepo.deleteById(1L);
        assertEquals(1, result);

        int remaining = userRepo.findAll().size();
        assertEquals(3, remaining);
    }

    @Test
    public void testCountUsers() {
        int count = userRepo.countUsers();

        assertEquals(4, count);
    }

    @Test
    public void findAllByUserNameExactMatch() {
        Set<User> userSet = userRepo.findAllByUserName("John", true);
        assertTrue(userSet.size() == 1);
    }

    @Test
    public void findAllByUserNamePartialMatch() {
        Set<User> userSet = userRepo.findAllByUserName("John", false);
        assertEquals(2, userSet.size());
    }
}
