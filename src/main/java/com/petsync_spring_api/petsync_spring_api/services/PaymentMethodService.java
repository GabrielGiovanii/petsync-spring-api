package com.petsync_spring_api.petsync_spring_api.services;

import com.petsync_spring_api.petsync_spring_api.entities.PaymentMethod;
import com.petsync_spring_api.petsync_spring_api.repositories.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodService {

    @Autowired
    private PaymentMethodRepository PaymentMethodRepository;

    public PaymentMethod put(PaymentMethod PaymentMethod) {return PaymentMethodRepository.save(PaymentMethod);}

    public List<PaymentMethod> getAll() {return PaymentMethodRepository.findAll();}
    public Optional<PaymentMethod> get(int id) {return PaymentMethodRepository.findById(id);}
    public void delete(int id) {PaymentMethodRepository.deleteById(id);}

}
