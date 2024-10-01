package com.petsync_spring_api.petsync_spring_api.services;

import com.petsync_spring_api.petsync_spring_api.entities.Schedule;
import com.petsync_spring_api.petsync_spring_api.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository ScheduleRepository;

    public Schedule put(Schedule Schedule) {return ScheduleRepository.save(Schedule);}

    public List<Schedule> getAll() {return ScheduleRepository.findAll();}
    public Optional<Schedule> get(int id) {return ScheduleRepository.findById(id);}
    public void delete(int id) {ScheduleRepository.deleteById(id);}

}
