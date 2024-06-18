package com.pt.isep.labdsoft.controller;

import com.pt.isep.labdsoft.dto.PageDTO;
import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.TransplantDonorDTO;
import com.pt.isep.labdsoft.dto.domain.TransplantDonorListDTO;
import com.pt.isep.labdsoft.service.domain.TransplantDonorService;
import com.pt.isep.labdsoft.util.converter.TransplantDonorConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transplant-donor")
public class TransplantDonorController {

    @Autowired
    private TransplantDonorService transplantDonorService;

    @Autowired
    private TransplantDonorConverter transplantDonorConverter;

    @PostMapping("/createDonor")
    public ResponseEntity<ResponseDTO> postTransplantDonor(@RequestBody TransplantDonorDTO transplantDonorDTO){
        ResponseDTO responseDTO = this.transplantDonorService.createTransplantDonor(transplantDonorDTO);
        return ResponseEntity.status(responseDTO.getStatusCode()).build();
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> getTransplantDonors(){
        return ResponseEntity.ok(this.transplantDonorService.findAll());
    }

    @GetMapping("/list")
    public PageDTO<TransplantDonorListDTO> list(@RequestParam(value = "filter", required = false) String filter, @RequestParam(value = "orderBy", required = false) String orderby, @RequestParam(value = "sortOrder", required = false) String sortOrder, @RequestParam(value = "pageNumber") Integer pageNumber, @RequestParam(value = "pageSize") Integer pageSize){
        return transplantDonorConverter.toPageDTO(transplantDonorService.findAll(orderby, sortOrder, pageNumber, pageSize));
    }
}
