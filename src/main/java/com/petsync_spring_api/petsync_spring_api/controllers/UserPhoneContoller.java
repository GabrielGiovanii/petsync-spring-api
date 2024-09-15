package com.petsync_spring_api.petsync_spring_api.controllers;

import com.petsync_spring_api.petsync_spring_api.entities.UserPhone;
import com.petsync_spring_api.petsync_spring_api.services.UserPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users/phones")
public class UserPhoneContoller {

    @Autowired
    private UserPhoneService userPhoneService;

    @PostMapping()
    public ResponseEntity<UserPhone> createUserPhones(@RequestBody UserPhone entity) {
        if(entity.getUser() == null || entity.getUser().getCpf() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        entity = userPhoneService.put(entity);

        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<UserPhone> getAllUserPhoness(@PathVariable Integer code) {
        Optional<UserPhone> entity = userPhoneService.findById(code);

        return entity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<UserPhone>> getUserPhones() {
        List<UserPhone> entities = userPhoneService.findAll();

        return ResponseEntity.ok(entities);
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<UserPhone> deleteUserPhones(@PathVariable Integer code) {
        userPhoneService.deleteById(code);

        return ResponseEntity.ok().build();
    }

}

