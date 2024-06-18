package com.pt.isep.labdsoft.controller;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.AnalysisRequestDTO;
import com.pt.isep.labdsoft.service.domain.AnalysisRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("analysis-request")
public class AnalysisRequestController {

    @Autowired
    private AnalysisRequestService analysisRequestService;

    @PostMapping
    public ResponseEntity<ResponseDTO> registerAnalysisRequest(@RequestBody AnalysisRequestDTO analysisRequestDTO) {
        ResponseDTO responseDTO = this.analysisRequestService.registerAnalysisRequest(analysisRequestDTO);
        return ResponseEntity.status(responseDTO.getStatusCode()).build();
    }
}
