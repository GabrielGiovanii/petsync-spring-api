package com.petsync_spring_api.petsync_spring_api.controllers;

import com.petsync_spring_api.petsync_spring_api.entities.PaymentMethod;
import com.petsync_spring_api.petsync_spring_api.services.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/paymets/methods")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService PaymentMethodService;

    @PostMapping
    public ResponseEntity<PaymentMethod> createPaymentMethod(@RequestBody PaymentMethod PaymentMethod) {
        PaymentMethodService.put(PaymentMethod);

        return ResponseEntity.status(HttpStatus.CREATED).body(PaymentMethod);
    }

    @GetMapping
    public ResponseEntity<List<PaymentMethod>> getAllPaymentMethods() {
        List<PaymentMethod> PaymentMethods = PaymentMethodService.getAll();

        return ResponseEntity.ok(PaymentMethods);
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<PaymentMethod> getPaymentMethod(@PathVariable String code) {
        int codeInt = Integer.parseInt(code);

        Optional<PaymentMethod> PaymentMethod = PaymentMethodService.get(codeInt);

        return PaymentMethod.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> deletePaymentMethod(@PathVariable String code) {
        int codeInt = Integer.parseInt(code);

        PaymentMethodService.delete(codeInt);
        return ResponseEntity.ok().build();
    }

}
