package com.examen_chitimus_mara.demo.dto;

import com.examen_chitimus_mara.demo.enums.PaymentStatus;
import com.examen_chitimus_mara.demo.enums.PaymentType;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@NoArgsConstructor
public class CreatePaymentRequestDTO {

    @NotBlank
    private PaymentType type;

    @NotBlank
    @Size(max = 200)
    private String customer;

    @NotBlank
    @Min(value = 0, message = "Ammount must have a positive value!")
    private double ammount;

    @NotBlank
    private PaymentStatus status;

    public CreatePaymentRequestDTO(@NotBlank PaymentType type, @NotBlank @Size(max = 200) String customer, @NotBlank @Min(value = 0, message = "Ammount must have a positive value!") double ammount, @NotBlank PaymentStatus status) {
        this.type = type;
        this.customer = customer;
        this.ammount = ammount;
        this.status = status;
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

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}
