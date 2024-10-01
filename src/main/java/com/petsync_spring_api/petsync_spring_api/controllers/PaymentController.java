package com.petsync_spring_api.petsync_spring_api.controllers;

import com.petsync_spring_api.petsync_spring_api.entities.Payment;
import com.petsync_spring_api.petsync_spring_api.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    @Autowired
    private PaymentService PaymentService;

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment Payment) {
        PaymentService.put(Payment);

        return ResponseEntity.status(HttpStatus.CREATED).body(Payment);
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> Payments = PaymentService.getAll();

        return ResponseEntity.ok(Payments);
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<Payment> getPayment(@PathVariable String code) {
        int codeInt = Integer.parseInt(code);

        Optional<Payment> Payment = PaymentService.get(codeInt);

        return Payment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> deletePayment(@PathVariable String code) {
        int codeInt = Integer.parseInt(code);

        PaymentService.delete(codeInt);
        return ResponseEntity.ok().build();
    }

}
