package com.examen_chitimus_mara.demo.repository;

import com.examen_chitimus_mara.demo.enums.PaymentStatus;
import com.examen_chitimus_mara.demo.enums.PaymentType;
import com.examen_chitimus_mara.demo.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    
    List<Payment> findByTypeAndStatus(PaymentType type, PaymentStatus status);

    List<Payment> findByType(PaymentType type);

    List<Payment> findByStatus(PaymentStatus status);
}



