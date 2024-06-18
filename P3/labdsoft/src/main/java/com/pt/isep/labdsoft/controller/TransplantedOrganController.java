package com.pt.isep.labdsoft.controller;

import com.pt.isep.labdsoft.dto.PageDTO;
import org.springframework.web.bind.annotation.*;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.TransplantedOrganDTO;
import com.pt.isep.labdsoft.service.domain.TransplantedOrganService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("transplanted-organ")
public class TransplantedOrganController {
    
    @Autowired
    private TransplantedOrganService transplantedOrganService;

    @PostMapping(value="add-transplanted-organ")
    public ResponseEntity<ResponseDTO> addTransplantedOrgan(@RequestBody TransplantedOrganDTO transplantedOrganDTO){
        ResponseDTO responseDTO = this.transplantedOrganService.addTransplantedOrgan(transplantedOrganDTO);
        return ResponseEntity.status(responseDTO.getStatusCode()).build();
    }

    @GetMapping()
    public PageDTO<TransplantedOrganDTO> getTransplantHistory(@RequestParam(value = "filter", required = false) String filter, @RequestParam(value = "orderBy", required = false) String orderBy, @RequestParam(value = "sortOrder", required = false) String sortOrder, @RequestParam(value = "pageNumber") Integer pageNumber, @RequestParam(value = "pageSize") Integer pageSize){
        return this.transplantedOrganService.findAll(orderBy, sortOrder, pageNumber, pageSize);
    }
    
}
