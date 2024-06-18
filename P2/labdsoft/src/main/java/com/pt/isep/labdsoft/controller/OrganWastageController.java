package com.pt.isep.labdsoft.controller;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.OrganWastageDTO;
import com.pt.isep.labdsoft.service.domain.OrganWastageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("organ-wastage")
public class OrganWastageController {

    @Autowired
    private OrganWastageService organWastageService;

    @PostMapping
    public ResponseEntity<ResponseDTO> postOrganWastage(@RequestBody OrganWastageDTO organWastageDTO){
        ResponseDTO responseDTO = this.organWastageService.registerOrganWastage(organWastageDTO);
        return ResponseEntity.status(responseDTO.getStatusCode()).build();
    }
}
