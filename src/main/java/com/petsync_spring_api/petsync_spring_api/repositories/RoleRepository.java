package com.petsync_spring_api.petsync_spring_api.repositories;

import com.petsync_spring_api.petsync_spring_api.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
