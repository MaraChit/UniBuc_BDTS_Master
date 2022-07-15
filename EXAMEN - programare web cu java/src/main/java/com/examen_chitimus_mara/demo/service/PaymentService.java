package com.examen_chitimus_mara.demo.service;

import com.examen_chitimus_mara.demo.enums.PaymentStatus;
import com.examen_chitimus_mara.demo.enums.PaymentType;
import com.examen_chitimus_mara.demo.exceptions.PaymentAlreadyCancelledException;
import com.examen_chitimus_mara.demo.exceptions.PaymentNotFoundException;
import com.examen_chitimus_mara.demo.model.Payment;
import com.examen_chitimus_mara.demo.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment create(Payment payment){
        return paymentRepository.save(payment);
    }

    public List<Payment> get(PaymentType type, PaymentStatus status) {
        if(type != null) {
            if(status != null) {
                return paymentRepository.findByTypeAndStatus(type,status);
            }
            return paymentRepository.findByType(type);
        }
        if(status != null) {
            return paymentRepository.findByStatus(status);
        }
        return paymentRepository.findAll();
    }

    public Payment update(Long id){
        Payment existingPayment = paymentRepository.findById(id).orElseThrow(()->new PaymentNotFoundException());
        if(existingPayment.getStatus() == PaymentStatus.CANCELED)
        {
            throw new PaymentAlreadyCancelledException();
        }

        existingPayment.setStatus(PaymentStatus.CANCELED);
        return paymentRepository.save(existingPayment);
    }
}
