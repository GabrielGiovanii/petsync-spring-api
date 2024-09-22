package com.petsync_spring_api.petsync_spring_api.controllers;

import com.petsync_spring_api.petsync_spring_api.dtos.UserResponseDTO;
import com.petsync_spring_api.petsync_spring_api.dtos.UserSaveDTO;
import com.petsync_spring_api.petsync_spring_api.entities.User;
import com.petsync_spring_api.petsync_spring_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService entityService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createEntity(@RequestBody UserSaveDTO dto) {
        if(dto.getCpf() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        if(entityService.findById(dto.getCpf()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        User entity = entityService.put(entityService.createEntity(dto));

        return ResponseEntity.status(HttpStatus.CREATED).body(new UserResponseDTO(entity));
    }

    @PutMapping
    public ResponseEntity<UserResponseDTO> updateEntity(@RequestBody UserSaveDTO dto) {
        if(dto.getCpf() == null) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        User entity = entityService.put(entityService.createEntity(dto));

        return ResponseEntity.status(HttpStatus.OK).body(new UserResponseDTO(entity));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllEntities() {
        List<User> entities = entityService.findAll();

        if(!entities.isEmpty()) {
            return ResponseEntity.ok().body(entities.stream().map(UserResponseDTO::new).toList());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<UserResponseDTO> getEntity(@PathVariable String code) {
        Optional<User> entity = entityService.findById(code);

        return entity.map(obj ->
                ResponseEntity
                        .ok()
                        .body(new UserResponseDTO(obj)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> deleteEntity(@PathVariable String code) {
        entityService.deleteById(code);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
