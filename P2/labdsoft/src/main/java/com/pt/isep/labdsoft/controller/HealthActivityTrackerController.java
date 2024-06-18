package com.pt.isep.labdsoft.controller;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.HealthActivityTrackerDTO;
import com.pt.isep.labdsoft.service.domain.HealthActivityTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health-activity-tracker")
public class HealthActivityTrackerController {

    @Autowired
    private HealthActivityTrackerService healthActivityTrackerService;

    @PostMapping(value = "/associate-transplant-recipient")
    public ResponseEntity<ResponseDTO> associateTransplantRecipient(@RequestBody HealthActivityTrackerDTO healthActivityTrackerDTO) {
        ResponseDTO responseDTO = this.healthActivityTrackerService.associateHealthActivityTracker(healthActivityTrackerDTO);
        return ResponseEntity.status(responseDTO.getStatusCode()).build();
    }
}
