package com.pt.isep.labdsoft.controller;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.AnalysisRequestDTO;
import com.pt.isep.labdsoft.service.domain.BloodAnalysisResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("analysis-results")
public class AnalysisResultsController {

    @Autowired
    private BloodAnalysisResultService bloodAnalysisResultService;

    @PostMapping
        public ResponseEntity<ResponseDTO> validateAnalysisResults(@RequestParam(value = "sampleIdentification") String sampleIdentification) {
        ResponseDTO responseDTO = this.bloodAnalysisResultService.validateAnalysisResults(sampleIdentification);
        return ResponseEntity.status(responseDTO.getStatusCode()).build();
    }
}
