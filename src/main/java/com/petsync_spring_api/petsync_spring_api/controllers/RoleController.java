package com.petsync_spring_api.petsync_spring_api.controllers;

import com.petsync_spring_api.petsync_spring_api.dtos.RoleDTO;
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
    private RoleService service;

    @PostMapping
    public ResponseEntity<RoleDTO> createEntity(@RequestBody RoleDTO dto) {

        Role entity = service.put(service.createEntity(dto));

        if(entity != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new RoleDTO(entity));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<RoleDTO>> getAllEntities() {
        List<Role> entities = service.findAll();

        if(!entities.isEmpty()) {
            return ResponseEntity.ok().body(entities.stream().map(RoleDTO::new).toList());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<RoleDTO> getEntity(@PathVariable Integer code) {
        Optional<Role> entity = service.findById(code);

        return entity.map(obj -> ResponseEntity
                        .ok().body(new RoleDTO(obj)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .build());
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> deleteEntity(@PathVariable Integer code) {
        service.deleteById(code);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
