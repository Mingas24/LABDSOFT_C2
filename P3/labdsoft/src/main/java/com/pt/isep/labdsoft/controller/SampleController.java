package com.pt.isep.labdsoft.controller;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.InputSampleDTO;
import com.pt.isep.labdsoft.service.domain.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("organ-sample")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @PostMapping
    public ResponseEntity<ResponseDTO> registerSample(@RequestBody InputSampleDTO inputSampleDTO) {
        ResponseDTO responseDTO = this.sampleService.registerSample(inputSampleDTO);
        return ResponseEntity.status(responseDTO.getStatusCode()).build();
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> getSamples() {
        return ResponseEntity.ok(this.sampleService.getSamples());
    }
}
