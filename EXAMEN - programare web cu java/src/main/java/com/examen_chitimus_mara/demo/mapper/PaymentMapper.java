package com.examen_chitimus_mara.demo.mapper;

import com.examen_chitimus_mara.demo.dto.CreatePaymentRequestDTO;
import com.examen_chitimus_mara.demo.model.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

        public Payment createPaymentRequestDtoToPayment(CreatePaymentRequestDTO request) {
            return new Payment(request.getType(), request.getCustomer(), request.getAmmount(), request.getStatus());
        }
}