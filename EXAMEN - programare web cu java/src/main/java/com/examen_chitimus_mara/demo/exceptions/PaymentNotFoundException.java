package com.examen_chitimus_mara.demo.exceptions;

public class PaymentNotFoundException extends RuntimeException {

    public PaymentNotFoundException() {
        super("There is no such payment.");
    }
}
