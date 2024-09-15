package com.petsync_spring_api.petsync_spring_api.repositories;

import com.petsync_spring_api.petsync_spring_api.entities.UserPhone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPhoneRepository extends JpaRepository<UserPhone, Integer> {
}
