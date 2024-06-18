package com.pt.isep.labdsoft.controller;

import com.pt.isep.labdsoft.dto.PageDTO;
import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.AppointmentDTO;
import com.pt.isep.labdsoft.service.domain.AppointmentService;
import com.pt.isep.labdsoft.util.converter.AppointmentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    AppointmentConverter appointmentConverter;

    @PostMapping("/create-appointment")
    public ResponseEntity<ResponseDTO> postAppointment(@RequestBody AppointmentDTO appointmentDTO){
        ResponseDTO responseDTO = this.appointmentService.createAppointment(appointmentDTO);
        return ResponseEntity.status(responseDTO.getStatusCode()).build();
    }
    
    @GetMapping("/list")
    public PageDTO<AppointmentDTO> list(@RequestParam(value = "filter", required = false) String filter, @RequestParam(value = "orderBy", required = false) String orderby, @RequestParam(value = "sortOrder", required = false) String sortOrder, @RequestParam(value = "pageNumber") Integer pageNumber, @RequestParam(value = "pageSize") Integer pageSize){
        return appointmentConverter.toPageDTO(appointmentService.findAll(orderby, sortOrder, pageNumber, pageSize));
    }
}
