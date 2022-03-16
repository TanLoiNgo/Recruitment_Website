package com.t03.recruitment_website;

import com.t03.recruitment_website.model.Users;
import com.t03.recruitment_website.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repo;

    @Test
    public void testCreateUser() {
        Users user = new Users();
        user.setEmail("ravikumar@gmail.com");
        //user.setPwd("ravi2020");
        user.setIs_active(false);

        Users savedUser = repo.save(user);

        Users existUser = entityManager.find(Users.class, savedUser.getUser_ID());

        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

    }
}