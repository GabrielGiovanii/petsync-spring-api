package com.petsync_spring_api.petsync_spring_api.controllers;

import com.petsync_spring_api.petsync_spring_api.entities.User;
import com.petsync_spring_api.petsync_spring_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService entityService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User entityRequest) {
        if(entityRequest.getCpf() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        if(entityService.findById(entityRequest.getCpf()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        User entity = entityService.put(entityRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(removeSensitiveDataFromEntity(entity));
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User entityRequest) {
        if(entityRequest.getCpf() == null) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        User entity = entityService.put(entityRequest);

        return ResponseEntity.status(HttpStatus.OK).body(removeSensitiveDataFromEntity(entity));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> entities = entityService.findAll();

        if(!entities.isEmpty()) {
            return ResponseEntity.ok().body(removeSensitiveDataFromEntity(entities));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<User> getUser(@PathVariable String code) {
        Optional<User> entity = entityService.findById(code);

        return entity.map(user ->
                ResponseEntity
                        .ok()
                        .body(removeSensitiveDataFromEntity(user)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> deleteUser(@PathVariable String code) {
        entityService.deleteById(code);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    private List<User> removeSensitiveDataFromEntity (List<User> entities) {
        return entities.stream().peek(obj -> obj.setPassword(null)).collect(Collectors.toList());
    }

    private User removeSensitiveDataFromEntity (User entity) {
         return new User(entity);
    }
}
