package com.example.proiectfinal.controller;

import com.example.proiectfinal.model.Book;
import com.example.proiectfinal.model.Category;
import com.example.proiectfinal.repository.BookRepository;
import com.example.proiectfinal.model.UserType;
import com.example.proiectfinal.repository.UserTypeRepository;
import com.example.proiectfinal.service.BookService;
import com.example.proiectfinal.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Autowired
    CategoryService categoryService;

    @Autowired
    private BookService bookService;

    Logger logger = LoggerFactory.getLogger(MainController.class);

    public MainController(BookService bookService, BookRepository bookRepository, UserTypeRepository userTypeRepository)
    {
        this.bookService = bookService;
        this.userTypeRepository = userTypeRepository;
    }

    @GetMapping("/")
    public String HomePage()
    {
        return "homePage.html";
    }

    @GetMapping("/register")
    public String SignUpForm(Model model)
    {
        model.addAttribute("user", new UserType());
        return "signUp.html";
    }

    @PostMapping("/process_register")
    public String processRegistration(UserType userType)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(userType.getPassword());
        userType.setPassword(encodedPassword);
        userTypeRepository.save(userType);
        logger.info("Your registration was successful! Congratulations!");
        return "registrationSucces.html";
    }

    @GetMapping("/books")
    public String ListBooks(Model model)
    {
        return FindPaginatedBookList(1,"bookId", "asc", model);
    }

    @GetMapping("/page/{pageNo}")
    public String FindPaginatedBookList(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model)
    {
        int pageSize = 3;

        Page<Book> page = bookService.findBooksWithPaginationAndSorting(pageNo, pageSize, sortField, sortDir);
        List<Book> bookList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("BookList", bookList);

        return "bookList.html";
    }

    @RequestMapping("/newBook")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        List<Category> categoriesAll = categoryService.findAll();

        model.addAttribute("categoriesAll", categoriesAll );
        return "bookform";
    }

    @PostMapping("/book")
    public String saveOrUpdate(@Valid @ModelAttribute Book book,
                               BindingResult bindingResult,
                               @ModelAttribute ArrayList<Category> categoriesAll
    ){
        System.out.println(book.getInfo());
        if (bindingResult.hasErrors()){
            return "bookform";
        }

        bookService.save(book);
        return "redirect:/books" ;
    }

    @GetMapping("deleteBook")
    public String DeleteBookForm()
    {
        return "deleteBook.html";
    }

    @RequestMapping("completeDeleteBook")
    public String DeleteBook(@RequestParam("bookId") Long bookId) {
        bookService.DeleteBook(bookId);
        return "redirect:/books" ;
    }

    @GetMapping("updateBook")
    public String UpdateBook()
    {
        return "updateBook.html";
    }

    @PostMapping("/completeUpdateBook")
    public String UpdateBookProcess(Book book)
    {
        Book updatedBook = bookService.GetBookById(book.getBookId());
        updatedBook.setTitle(book.getTitle());
        updatedBook.setPublishingDate(book.getPublishingDate());
        updatedBook.setRating(book.getRating());
        updatedBook.setPublishingHouse(book.getPublishingHouse());
        bookService.save(updatedBook);
        return "redirect:/books";
    }
}
