//package com.awbd.lab9;
//
//import com.awbd.lab9.domain.Book;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ActiveProfiles;
//
//import javax.persistence.EntityManager;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ActiveProfiles("mysql")
//@Rollback(false)
//public class EntityManagerTest {
//    @Autowired
//    private EntityManager entityManager;
//
//    @Test
//    public void findProduct() {
//        Book bookFound = entityManager.find(Book.class, 1L);
//        assertEquals(bookFound.getCode(), "PCEZ");
//    }
//
//    @Test public void updateProduct() {
//        Book bookFound = entityManager.find(Book.class, 1L);
//        bookFound.setCurrency(Currency.USD); entityManager.persist(bookFound); entityManager.flush();
//    }
//
//    @Test public void findCurrency() {
//        Book bookFound = entityManager.find(Book.class, 1L);
//        assertEquals(bookFound.getCurrency(),Currency.USD);
//    }
//}
