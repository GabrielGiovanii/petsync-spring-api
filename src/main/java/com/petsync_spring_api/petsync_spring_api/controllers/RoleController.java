package com.petsync_spring_api.petsync_spring_api.controllers;

import com.petsync_spring_api.petsync_spring_api.entities.Role;
import com.petsync_spring_api.petsync_spring_api.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    @Autowired
    private RoleService entityService;

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role entityRequest) {
        Role entity = entityService.put(entityRequest);

        if(entity != null) {
            return ResponseEntity.status(HttpStatus.OK).body(entity);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> entities = entityService.findAll();

        if(!entities.isEmpty()) {
            return ResponseEntity.ok().body(entities);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<Role> getRole(@PathVariable Integer code) {
        Optional<Role> entity = entityService.findById(code);

        return entity.map(role -> ResponseEntity
                .ok().body(role))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .build());
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> deleteRole(@PathVariable Integer code) {
        entityService.deleteById(code);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
