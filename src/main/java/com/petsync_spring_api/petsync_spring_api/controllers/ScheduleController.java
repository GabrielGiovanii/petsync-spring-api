package com.petsync_spring_api.petsync_spring_api.controllers;

import com.petsync_spring_api.petsync_spring_api.entities.Schedule;
import com.petsync_spring_api.petsync_spring_api.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService ScheduleService;

    @PostMapping
    public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule Schedule) {
        ScheduleService.put(Schedule);

        return ResponseEntity.status(HttpStatus.CREATED).body(Schedule);
    }

    @GetMapping
    public ResponseEntity<List<Schedule>> getAllSchedules() {
        List<Schedule> Schedules = ScheduleService.getAll();

        return ResponseEntity.ok(Schedules);
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<Schedule> getSchedule(@PathVariable String code) {
        int codeInt = Integer.parseInt(code);

        Optional<Schedule> Schedule = ScheduleService.get(codeInt);

        return Schedule.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable String code) {
        int codeInt = Integer.parseInt(code);

        ScheduleService.delete(codeInt);
        return ResponseEntity.ok().build();
    }

}
