package com.awbd.lab9.controllers;


import com.awbd.AWBD_books.domain.Book;
import com.awbd.AWBD_books.services.BookService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("mysql")
public class BookControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BookService bookService;

    @MockBean
    Model model;



    @Disabled
    @Test
    public void showByIdMvc() throws Exception {

        mockMvc.perform(get("/product/info/{id}", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("info"));
    }



    @Test
    @WithMockUser(username = "guest", password = "12345", roles = "GUEST")
    public void showByIdMockMvc() throws Exception {
        Long id = 1l;
        Book bookTest = new Book();
        bookTest.setId(id);
        bookTest.setTitle("test");

        when(bookService.findById(id)).thenReturn(bookTest);

        mockMvc.perform(get("/product/info/{id}", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("info"))
                .andExpect(model().attribute("product", bookTest))
                //.andExpect(content().contentType(MediaType.TEXT_HTML));
                .andExpect(content().contentType("text/html;charset=UTF-8"));
    }



    @Test
    @WithMockUser(username = "guest", password = "12345", roles = "GUEST")
    public void deleteByIdMockMvc() throws Exception {

        mockMvc.perform(get("/product/delete/{id}", "1"))
                .andExpect(status().isForbidden());
    }

}

