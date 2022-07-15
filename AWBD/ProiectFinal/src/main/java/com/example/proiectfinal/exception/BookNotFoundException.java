package com.example.proiectfinal.exception;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException() {
        super("Sorry! It seems that this book does not exist.");
    }
}
