package com.petsync_spring_api.petsync_spring_api.services;

import com.petsync_spring_api.petsync_spring_api.entities.Payment;
import com.petsync_spring_api.petsync_spring_api.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository PaymentRepository;

    public Payment put(Payment Payment) {return PaymentRepository.save(Payment);}

    public List<Payment> getAll() {return PaymentRepository.findAll();}
    public Optional<Payment> get(int id) {return PaymentRepository.findById(id);}
    public void delete(int id) {PaymentRepository.deleteById(id);}

}
