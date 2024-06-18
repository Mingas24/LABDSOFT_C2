package com.pt.isep.labdsoft.controller;

import com.pt.isep.labdsoft.dto.AnalysisRequestDTO;
import com.pt.isep.labdsoft.dto.AnalysisResultDTO;
import com.pt.isep.labdsoft.service.AnalysisResultSimulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("analysis-request-equipments")
public class AnalysisRequestController {

    @Autowired
    private AnalysisResultSimulator analysisResultSimulator;

    @PostMapping
    public ResponseEntity<AnalysisResultDTO> registerAnalysisRequest(@RequestBody AnalysisRequestDTO analysisRequestDTO) {
        return ResponseEntity.ok(analysisResultSimulator.simulateAnalysisResults(analysisRequestDTO.getAnalysisTypes()));
    }
}
