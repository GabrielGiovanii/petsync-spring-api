package com.petsync_spring_api.petsync_spring_api.controllers;

import com.petsync_spring_api.petsync_spring_api.entities.ClientPhone;
import com.petsync_spring_api.petsync_spring_api.entities.Role;
import com.petsync_spring_api.petsync_spring_api.services.ClientPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/clients/phones")
public class ClientPhoneContoller {

    @Autowired
    private ClientPhoneService clientPhoneService;

    @PostMapping()
    public ResponseEntity<ClientPhone> insert(@RequestBody ClientPhone clientPhone) {
        clientPhone = clientPhoneService.put(clientPhone);

        return ResponseEntity.status(HttpStatus.CREATED).body(clientPhone);
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<ClientPhone> findByCode(@PathVariable Integer code) {
        Optional<ClientPhone> entity = clientPhoneService.findById(code);

        return entity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ClientPhone>> findAll() {
        List<ClientPhone> clientPhones = clientPhoneService.findAll();

        return ResponseEntity.ok(clientPhones);
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<ClientPhone> delete(@PathVariable Integer code) {
        clientPhoneService.deleteById(code);
        return ResponseEntity.ok().build();
    }

}
