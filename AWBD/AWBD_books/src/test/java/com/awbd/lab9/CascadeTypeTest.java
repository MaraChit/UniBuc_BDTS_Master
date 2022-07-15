//package com.awbd.lab9;
//
//import com.awbd.lab9.domain.Book;
//import com.awbd.lab9.domain.Reader;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ActiveProfiles;
//
//import javax.persistence.EntityManager;
//import java.util.Arrays;
//
//
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ActiveProfiles("mysql")
//@Rollback(false)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class CascadeTypeTest {
//    @Autowired private EntityManager entityManager;
//
//    @Test
//    @Order(1)
//    public void saveParticipant() {
//        Reader reader = new Reader();
//        reader.setFirstName("Will");
//        reader.setLastName("Snow");
//        Book book = new Book();
//        book.setTitle("Impression, Sunrise");
//        book.setPrice(300D);
//        //book.setCode("PMON");
//        //book.setSeller(reader);
//        //reader.setBooks(Arrays.asList(book));
//
//        entityManager.persist(reader);
//        entityManager.flush();
//        entityManager.clear();
//    }
//
//
//    @Test
//    @Order(2)
//    public void updateParticipant(){
//        Book book = entityManager.find(Book.class, 2L);
//        Reader reader = book.getSeller();
//        reader.setFirstName("Wiilliam");
//        reader.getBooks().forEach(prod -> {prod.setCurrency(Currency.USD);});
//        entityManager.merge(reader);
//        entityManager.flush(); }
//
//
//    @ParameterizedTest
//    @Order(3)
//    @ValueSource(longs = {1, 2})
//    public void orphanRemoval(long id){
//        Book book = entityManager.find(Book.class, id);
//        book.setInfo(null);
//        entityManager.persist(book);
//        entityManager.flush();
//    }
//
//
//}