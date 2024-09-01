package com.petsync_spring_api.petsync_spring_api.controllers;

import com.petsync_spring_api.petsync_spring_api.entities.User;
import com.petsync_spring_api.petsync_spring_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService entityService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> entities = entityService.selectAll();

        if(!entities.isEmpty()) {
            return ResponseEntity.ok().body(entities);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<User> findByCode(@PathVariable String code) {
        User entity = entityService.selectByCode(code);

        if(entity != null) {
            return ResponseEntity.ok().body(entity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User entityRequest) {
        User entity = entityService.insert(entityRequest);

        if(entity != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(entity);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User entityRequest) {
        User entity = entityService.update(entityRequest);

        HttpStatus httpStatus;

        if(entity != null) {
            return ResponseEntity.status(HttpStatus.OK).body(entity);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> deleteByCode(@PathVariable String code) {
        int numberOfAffectedRows = entityService.deleteByCode(code);

        HttpStatus httpStatus;

        if(numberOfAffectedRows == 1) {
            httpStatus = HttpStatus.NO_CONTENT;
        } else if (numberOfAffectedRows == 0) {
            httpStatus = HttpStatus.NOT_FOUND;
        } else {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return ResponseEntity.status(httpStatus).build();
    }
}
