package com.pt.isep.labdsoft.controller;

import com.pt.isep.labdsoft.dto.PageDTO;
import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.TransplantRecipientDTO;
import com.pt.isep.labdsoft.dto.domain.UpdateRecipientUrgencyStatusDTO;
import com.pt.isep.labdsoft.dto.domain.TransplantRecipientListDTO;
import com.pt.isep.labdsoft.service.domain.TransplantRecipientService;
import com.pt.isep.labdsoft.util.converter.TransplantRecipientConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transplant-recipient")
public class TransplantRecipientController {

    @Autowired
    private TransplantRecipientService transplantRecipientService;

    @Autowired
    private TransplantRecipientConverter transplantRecipientConverter;

    @PostMapping
    public ResponseEntity<ResponseDTO> postTransplantRecipient(@RequestBody TransplantRecipientDTO transplantRecipientDTO) {
        ResponseDTO responseDTO = this.transplantRecipientService.createTransplantRecipient(transplantRecipientDTO);
        return ResponseEntity.status(responseDTO.getStatusCode()).build();
    }

    @PostMapping(value= "/update-status")
    public ResponseEntity<ResponseDTO> updateRecipientStatus(@RequestBody UpdateRecipientUrgencyStatusDTO updateRecipientUrgencyStatusDTO){
        ResponseDTO responseDTO = this.transplantRecipientService.updateRecipientStatus(updateRecipientUrgencyStatusDTO);
        return ResponseEntity.status(responseDTO.getStatusCode()).build();
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> getTransplantRecipients() {
        return ResponseEntity.ok(this.transplantRecipientService.getTransplantRecipients());
    }

    @GetMapping(value = "/get-recipient-by-id/{identification}")
    public ResponseEntity<ResponseDTO> getTransplantRecipientByIdentification(@PathVariable String identification) {
        return ResponseEntity.ok(this.transplantRecipientService.getTransplantRecipientByIdentification(identification));
    }

    @GetMapping("/list")
    public PageDTO<TransplantRecipientListDTO> list(@RequestParam(value = "filter", required = false) String filter, @RequestParam(value = "orderBy", required = false) String orderBy, @RequestParam(value = "sortOrder", required = false) String sortOrder, @RequestParam(value = "pageNumber") Integer pageNumber, @RequestParam(value = "pageSize") Integer pageSize){
        return transplantRecipientConverter.toPageDTO(transplantRecipientService.findAll(orderBy, sortOrder, pageNumber, pageSize));
    }
}
