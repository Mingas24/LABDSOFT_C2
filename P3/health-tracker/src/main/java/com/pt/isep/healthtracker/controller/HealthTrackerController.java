package com.pt.isep.healthtracker.controller;

import com.pt.isep.healthtracker.dto.HealthTrackerResultDTO;
import com.pt.isep.healthtracker.dto.VitalSignsDTO;
import com.pt.isep.healthtracker.service.HealthTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health-tracker")
public class HealthTrackerController {

    @Autowired
    private HealthTrackerService healthTrackerService;

    @PostMapping
    public ResponseEntity<HealthTrackerResultDTO> checkHealthActivityTracker(@RequestBody VitalSignsDTO vitalSignsDTO) {
        return ResponseEntity.ok(healthTrackerService.checkHealthActivityTracker(vitalSignsDTO));
    }
}
