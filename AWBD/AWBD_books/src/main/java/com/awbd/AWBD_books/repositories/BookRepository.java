package com.awbd.AWBD_books.repositories;

import com.awbd.AWBD_books.domain.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
//    @Query("select p from Book p where p.seller.id = ?1")
//    List<Book> findBySeller(Long sellerId);
//
//    @Query("select p from Book p where p.seller.firstName = :firstName and p.seller.lastName = :lastName")
//    List<Book> findBySellerName(@Param("firstName") String sellerFirstName, @Param("lastName") String sellerLastName);

}
