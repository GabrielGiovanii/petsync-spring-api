package com.petsync_spring_api.petsync_spring_api.services;

import com.petsync_spring_api.petsync_spring_api.entities.SurgeryHistory;
import com.petsync_spring_api.petsync_spring_api.repositories.SurgeryHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurgeryHistoryService {

    @Autowired
    private SurgeryHistoryRepository SurgeryHistoryRepository;

    public SurgeryHistory put(SurgeryHistory SurgeryHistory) {return SurgeryHistoryRepository.save(SurgeryHistory);}

    public List<SurgeryHistory> getAll() {return SurgeryHistoryRepository.findAll();}
    public Optional<SurgeryHistory> get(int id) {return SurgeryHistoryRepository.findById(id);}
    public void delete(int id) {SurgeryHistoryRepository.deleteById(id);}

}
