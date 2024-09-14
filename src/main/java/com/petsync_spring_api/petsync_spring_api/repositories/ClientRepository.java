package com.petsync_spring_api.petsync_spring_api.repositories;

import com.petsync_spring_api.petsync_spring_api.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
}
