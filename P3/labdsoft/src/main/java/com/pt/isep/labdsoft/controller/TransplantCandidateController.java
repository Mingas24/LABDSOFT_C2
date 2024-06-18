package com.pt.isep.labdsoft.controller;

import com.pt.isep.labdsoft.dto.PageDTO;
import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.TransplantCandidateDTO;
import com.pt.isep.labdsoft.service.domain.TransplantCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transplant-candidate")
public class TransplantCandidateController {

    @Autowired
    private TransplantCandidateService transplantCandidateService;

    @GetMapping
    public ResponseEntity<ResponseDTO> getTransplantCandidates() {
        return ResponseEntity.ok(this.transplantCandidateService.getTransplantCandidates());
    }

    @GetMapping("/list")
    public PageDTO<TransplantCandidateDTO> list(@RequestParam(value = "filter", required = false) String filter, @RequestParam(value = "orderBy", required = false) String orderBy, @RequestParam(value = "sortOrder", required = false) String sortOrder, @RequestParam(value = "pageNumber") Integer pageNumber, @RequestParam(value = "pageSize") Integer pageSize){
        return this.transplantCandidateService.getTransplantCandidates(orderBy, sortOrder, pageNumber, pageSize);
    }

    @GetMapping("/getCandidatePosition/{fullName}/{organ}")
    public ResponseDTO getCandidatePosition(@PathVariable String fullName,@PathVariable String organ){
        return this.transplantCandidateService.getCandidatePosition(fullName,organ);
    }
}
