package com.pt.isep.labdsoft.controller;

import com.pt.isep.labdsoft.dto.PageDTO;
import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.HealthActivityTrackerDTO;
import com.pt.isep.labdsoft.dto.domain.HealthTrackerRegistrationDTO;
import com.pt.isep.labdsoft.dto.domain.HealthTrackerSimulatorDTO;
import com.pt.isep.labdsoft.dto.domain.VitalSignsPageDTO;
import com.pt.isep.labdsoft.service.domain.HealthActivityTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("health-activity-tracker")
public class HealthActivityTrackerController {

    @Autowired
    private HealthActivityTrackerService healthActivityTrackerService;

    @PostMapping
    public ResponseEntity<ResponseDTO> registerHeathTracker(@RequestBody HealthTrackerRegistrationDTO healthTrackerRegistrationDTO) {
        ResponseDTO responseDTO = this.healthActivityTrackerService.registerHeathTracker(healthTrackerRegistrationDTO);
        return ResponseEntity.status(responseDTO.getStatusCode()).build();
    }

    @PostMapping(value = "/associate-transplant-recipient")
    public ResponseEntity<ResponseDTO> associateTransplantRecipient(@RequestBody HealthActivityTrackerDTO healthActivityTrackerDTO) {
        ResponseDTO responseDTO = this.healthActivityTrackerService.associateHealthActivityTracker(healthActivityTrackerDTO);
        return ResponseEntity.status(responseDTO.getStatusCode()).build();
    }

    @PostMapping(value = "/simulator")
    public ResponseEntity<ResponseDTO> healthTrackerSimulator(@RequestBody HealthTrackerSimulatorDTO healthTrackerSimulatorDTO) throws Exception {
        ResponseDTO responseDTO = this.healthActivityTrackerService.healthTrackerSimulator(healthTrackerSimulatorDTO);
        return ResponseEntity.status(responseDTO.getStatusCode()).build();
    }

    @GetMapping
    public PageDTO<VitalSignsPageDTO> getHealthTrackerActivityStatus(@RequestParam(value = "filter", required = false) String filter, @RequestParam(value = "orderBy", required = false) String orderBy, @RequestParam(value = "sortOrder", required = false) String sortOrder, @RequestParam(value = "pageNumber") Integer pageNumber, @RequestParam(value = "pageSize") Integer pageSize){
        return this.healthActivityTrackerService.getHealthTrackerActivityStatus(orderBy, sortOrder, pageNumber, pageSize);
    }
}
