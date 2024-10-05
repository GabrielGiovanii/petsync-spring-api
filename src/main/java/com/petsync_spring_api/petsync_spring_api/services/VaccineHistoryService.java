package com.petsync_spring_api.petsync_spring_api.services;

import com.petsync_spring_api.petsync_spring_api.entities.VaccineHistory;
import com.petsync_spring_api.petsync_spring_api.repositories.VaccineHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VaccineHistoryService {

    @Autowired
    private VaccineHistoryRepository VaccineHistoryRepository;

    public VaccineHistory put(VaccineHistory VaccineHistory) {return VaccineHistoryRepository.save(VaccineHistory);}

    public List<VaccineHistory> getAll() {return VaccineHistoryRepository.findAll();}
    public Optional<VaccineHistory> get(int id) {return VaccineHistoryRepository.findById(id);}
    public void delete(int id) {VaccineHistoryRepository.deleteById(id);}

}
