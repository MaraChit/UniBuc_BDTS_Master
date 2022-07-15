package com.examen_chitimus_mara.demo.controller;

import com.examen_chitimus_mara.demo.dto.CreatePaymentRequestDTO;
import com.examen_chitimus_mara.demo.enums.PaymentStatus;
import com.examen_chitimus_mara.demo.enums.PaymentType;
import com.examen_chitimus_mara.demo.mapper.PaymentMapper;
import com.examen_chitimus_mara.demo.model.Payment;
import com.examen_chitimus_mara.demo.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.*;
import java.util.List;

@RestController
@RequestMapping("/payment")
@Validated
public class PaymentController {
    private PaymentService paymentService;
    private PaymentMapper paymentMapper;

    public PaymentController(PaymentService paymentService, PaymentMapper paymentMapper) {
        this.paymentService = paymentService;
        this.paymentMapper = paymentMapper;
    }

    @PostMapping
    public ResponseEntity<Payment> create(@Valid @RequestBody CreatePaymentRequestDTO request) {
        Payment payment = paymentService.create(paymentMapper.createPaymentRequestDtoToPayment(request));
        return ResponseEntity.created(URI.create("/payment/" + payment.getId()))
                .body(payment);
    }

    @GetMapping
    public List<Payment> get(@RequestParam(required = false) PaymentType type,
                             @RequestParam(required = false) PaymentStatus status) {
        return paymentService.get(type, status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> update(
            @PathVariable long id) {
        return ResponseEntity.ok(paymentService.update(id));
    }
}
