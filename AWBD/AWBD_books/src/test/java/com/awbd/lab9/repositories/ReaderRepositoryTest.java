//package com.awbd.lab9.repositories;
//
//
//import com.awbd.lab9.domain.Reader;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ActiveProfiles("mysql")
//@Rollback(false)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@Slf4j
//public class ReaderRepositoryTest {
//
//    @Autowired
//    private ReaderRepository readerRepository;
//
//    @Test
//    @Order(1)
//    public void addParticipant() {
//        Reader reader = new Reader();
//        reader.setFirstName("John");
//        reader.setLastName("Adam");
//        readerRepository.save(reader);
//    }
//
//
//    @Test
//    @Order(2)
//    public void findByName() {
//        List<Reader> readers = readerRepository.findByLastNameLike("%da%");
//        assertFalse(readers.isEmpty());
//        log.info("findByLastNameLike ...");
//        readers.forEach(participant -> log.info(participant.getLastName()));
//    }
//
//    @Test
//    @Order(3)
//    public void findByIds() {
//        List<Reader> readers = readerRepository.findByIdIn(Arrays.asList(1L,2L));
//        assertFalse(readers.isEmpty());
//        log.info("findByIds ...");
//        readers.forEach(participant -> log.info(participant.getLastName()));
//    }
//
//
//}
