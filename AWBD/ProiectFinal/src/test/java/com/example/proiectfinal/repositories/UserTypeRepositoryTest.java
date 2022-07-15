package com.example.proiectfinal.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.proiectfinal.model.UserType;
import com.example.proiectfinal.repository.UserTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserTypeRepositoryTest {

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void TestCreateUser()
    {
        UserType userType = new UserType();
        userType.setPassword("test");
        userType.setEmail("test.test@mail.ro");
        userType.setLastName("test");
        userType.setName("test");

        UserType savedUser = userTypeRepository.save(userType);

        UserType existsUser = testEntityManager.find(UserType.class, savedUser.getId());

        assertThat(existsUser.getEmail()).isEqualTo(userType.getEmail());
    }

    @Test
    public void TestFindUserByEmail()
    {
        String email = "mara.chit@gmail.com";

        UserType userType = userTypeRepository.findByEmail(email);
        assertThat(userType).isNotNull();
    }
}
