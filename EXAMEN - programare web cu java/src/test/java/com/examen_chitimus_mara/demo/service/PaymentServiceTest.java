package com.examen_chitimus_mara.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import com.examen_chitimus_mara.demo.enums.PaymentStatus;
import com.examen_chitimus_mara.demo.enums.PaymentType;
import com.examen_chitimus_mara.demo.model.Payment;
import com.examen_chitimus_mara.demo.repository.PaymentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentService paymentService;

    @Test
    @DisplayName("Payment created successfully")
    void create() {
        //arrange
        Payment payment = new Payment(PaymentType.ONLINE, "JON", 12.0, PaymentStatus.NEW);
        Payment savedPayment = new Payment(1, PaymentType.ONLINE, "JON", 12.0, PaymentStatus.NEW);
        when(paymentRepository.save(payment)).thenReturn(savedPayment);

        //act
        Payment result = paymentService.create(payment);

        //assert
        assertNotNull(result);
        assertEquals(savedPayment.getId(), result.getId());
        assertEquals(savedPayment.getType(), result.getType());
        assertEquals(savedPayment.getCustomer(), result.getCustomer());
        assertEquals(savedPayment.getStatus(), result.getStatus());
        assertEquals(savedPayment.getAmmount(), result.getAmmount());

        verify(paymentRepository).save(payment);
    }

    @Test
    @DisplayName("Get payments by status")
    void getByStatus() {
        //arrange
        PaymentStatus status = PaymentStatus.NEW;
        Payment payment = new Payment(1, PaymentType.ONLINE, "JON", 12.0, PaymentStatus.NEW);
        when(paymentRepository.findByStatus(status))
                .thenReturn(List.of(payment));

        //act
        List<Payment> result = paymentService.get(null, status);

        //assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(payment, result.get(0));

        verify(paymentRepository, never()).findByType(any());
        verify(paymentRepository, never()).findByTypeAndStatus(any(), any());
        verify(paymentRepository).findByStatus(status);
        verify(paymentRepository, never()).findAll();
    }

    @Test
    @DisplayName("Get payments by type")
    void getByType() {
        //arrange
        PaymentType type = PaymentType.ONLINE;
        Payment payment = new Payment(1, PaymentType.ONLINE, "JON", 12.0, PaymentStatus.NEW);
        when(paymentRepository.findByType(type))
                .thenReturn(List.of(payment));

        //act
        List<Payment> result = paymentService.get(type, null);

        //assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(payment, result.get(0));

        verify(paymentRepository, never()).findByStatus(any());
        verify(paymentRepository, never()).findByTypeAndStatus(any(), any());
        verify(paymentRepository).findByType(type);
        verify(paymentRepository, never()).findAll();
    }

    @Test
    @DisplayName("Get payments by type and status")
    void getByTypeAndStatus() {
        //arrange
        PaymentType type = PaymentType.ONLINE;
        PaymentStatus status = PaymentStatus.NEW;
        Payment payment = new Payment(1, PaymentType.ONLINE, "JON", 12.0, PaymentStatus.NEW);
        when(paymentRepository.findByTypeAndStatus(type,status))
                .thenReturn(List.of(payment));

        //act
        List<Payment> result = paymentService.get(type, status);

        //assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(payment, result.get(0));

        verify(paymentRepository, never()).findByStatus(any());
        verify(paymentRepository).findByTypeAndStatus(type, status);
        verify(paymentRepository,never()).findByType(any());
        verify(paymentRepository, never()).findAll();
    }

    @Test
    @DisplayName("Get payments with no type and status filter")
    void getAll() {
        //arrange
        Payment payment = new Payment(1, PaymentType.ONLINE, "JON", 12.0, PaymentStatus.NEW);
        when(paymentRepository.findAll())
                .thenReturn(List.of(payment));

        //act
        List<Payment> result = paymentService.get(null, null);

        //assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(payment, result.get(0));

        verify(paymentRepository, never()).findByStatus(any());
        verify(paymentRepository, never()).findByTypeAndStatus(any(), any());
        verify(paymentRepository,never()).findByType(any());
        verify(paymentRepository).findAll();
    }
}
