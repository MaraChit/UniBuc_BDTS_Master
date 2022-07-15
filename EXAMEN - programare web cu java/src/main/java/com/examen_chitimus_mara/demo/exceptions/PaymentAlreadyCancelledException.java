package com.examen_chitimus_mara.demo.exceptions;

public class PaymentAlreadyCancelledException extends RuntimeException  {

    public PaymentAlreadyCancelledException() {
        super("The payment is already cancelled.");
    }
}
