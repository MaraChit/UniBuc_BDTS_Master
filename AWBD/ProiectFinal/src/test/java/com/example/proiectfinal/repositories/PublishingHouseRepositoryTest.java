package com.example.proiectfinal.repositories;

import com.example.proiectfinal.model.PublishingHouse;
import com.example.proiectfinal.repository.PublishingHouseRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PublishingHouseRepositoryTest {
    @Autowired
    PublishingHouseRepository publishingHouseRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void TestAddPublishingHouses()
    {
        PublishingHouse publishingHouse = new PublishingHouse();
        publishingHouse.setPublishingHouseName("Nemira");
        publishingHouse.setCountry("Romania");

        PublishingHouse savedPublishingHouse = publishingHouseRepository.save(publishingHouse);

        PublishingHouse existingPublishingHouse = testEntityManager.find(PublishingHouse.class, savedPublishingHouse.getPublishingHouseId());

        log.info("test add publishing house in publishing house repository ...");
        assertThat(existingPublishingHouse.getPublishingHouseName()).isEqualTo(publishingHouse.getPublishingHouseName());
        assertThat(existingPublishingHouse.getCountry()).isEqualTo(publishingHouse.getCountry());
    }
}
