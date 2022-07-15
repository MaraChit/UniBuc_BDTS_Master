package com.example.proiectfinal.service;

import com.example.proiectfinal.exception.BookNotFoundException;
import com.example.proiectfinal.model.Book;
import com.example.proiectfinal.model.Category;
import com.example.proiectfinal.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    BookRepository bookRepository;

    public BookService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    public List<Book> ShowBookByTitle(String title)
    {
        if(title != null) {
             return bookRepository.findByTitle(title);
        }
        return bookRepository.findAll();
    }

    public Book GetBookById(Long id) {
        return bookRepository.findByBookId(id);
    }

    public void DeleteBook(Long id)
    {
        Optional<Book> paymentDontExist = bookRepository.findById(id);
        if (!paymentDontExist.isPresent()) {
            throw new BookNotFoundException();
        }
        bookRepository.deleteById(id);
    }

    public Page<Book> findBooksWithPaginationAndSorting(int pageNo, int pageSize, String sortField, String sortDirection)
    {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.bookRepository.findAll(pageable);
    }

    public List<Book> findAll(){
        List<Book> books = new LinkedList<>();
        bookRepository.findAll().iterator().forEachRemaining(books::add);
        return books;
    }

    public Book save(Book book) {
        Book savedBook = bookRepository.save(book);
        return savedBook;
    }

}
