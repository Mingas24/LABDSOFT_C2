package com.pt.isep.labdsoft.controller;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.TransplantRecipientDTO;
import com.pt.isep.labdsoft.dto.domain.VitalsAppointmentDTO;
import com.pt.isep.labdsoft.service.domain.VitalsAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vitals-appointment")
public class VitalsAppointmentController {

    @Autowired
    private VitalsAppointmentService vitalsAppointmentService;

    @PostMapping
    public ResponseEntity<ResponseDTO> postVitalSignsAppointment(@RequestBody VitalsAppointmentDTO vitalsAppointmentDTO) {
        ResponseDTO responseDTO = this.vitalsAppointmentService.createAppointment(vitalsAppointmentDTO);
        return ResponseEntity.status(responseDTO.getStatusCode()).build();
    }
}
