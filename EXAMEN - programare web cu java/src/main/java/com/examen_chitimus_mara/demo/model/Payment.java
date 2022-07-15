package com.examen_chitimus_mara.demo.model;

import com.examen_chitimus_mara.demo.enums.PaymentStatus;
import com.examen_chitimus_mara.demo.enums.PaymentType;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "payments")
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private PaymentType type;

    private String customer;

    private double ammount;

    private PaymentStatus status;

    public Payment(PaymentType type, String customer,  Double ammount, PaymentStatus status) {
        this.type = type;
        this.customer = customer;
        this.ammount = ammount;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PaymentType getType() {
        return type;
    }

    public void setType(PaymentType type) {
        this.type = type;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Double getAmmount() {
        return ammount;
    }

    public void setAmmount(Double ammount) {
        this.ammount = ammount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}
