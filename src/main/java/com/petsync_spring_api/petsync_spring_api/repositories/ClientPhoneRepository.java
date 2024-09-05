package com.petsync_spring_api.petsync_spring_api.repositories;

import com.petsync_spring_api.petsync_spring_api.entities.ClientPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientPhoneRepository extends JpaRepository<ClientPhone, Integer> {
}
