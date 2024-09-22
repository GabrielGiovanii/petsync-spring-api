package com.petsync_spring_api.petsync_spring_api.controllers;

import com.petsync_spring_api.petsync_spring_api.dtos.UserPhoneDTO;
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
    public ResponseEntity<UserPhoneDTO> createUserPhones(@RequestBody UserPhoneDTO dto) {
        if(dto.getUserCpf() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

         UserPhone entity = userPhoneService.put(userPhoneService.createEntity(dto));

        return ResponseEntity.status(HttpStatus.OK).body(new UserPhoneDTO(entity));
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<UserPhoneDTO> getAllUserPhoness(@PathVariable Integer code) {
        Optional<UserPhone> entity = userPhoneService.findById(code);

        return entity.map(userPhone -> ResponseEntity
                        .status(HttpStatus.OK)
                        .body(new UserPhoneDTO(userPhone)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<UserPhoneDTO>> getUserPhones() {
        List<UserPhone> entities = userPhoneService.findAll();

        return ResponseEntity.ok(entities.stream().map(UserPhoneDTO::new).toList());
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> deleteUserPhones(@PathVariable Integer code) {
        userPhoneService.deleteById(code);

        return ResponseEntity.ok().build();
    }

}

