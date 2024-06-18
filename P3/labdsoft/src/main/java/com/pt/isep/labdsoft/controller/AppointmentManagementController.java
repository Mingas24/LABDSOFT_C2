package com.pt.isep.labdsoft.controller;

import com.pt.isep.labdsoft.dto.PageDTO;
import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.AppointmentManagementDTO;
import com.pt.isep.labdsoft.service.domain.AppointmentManagementService;
import com.pt.isep.labdsoft.util.converter.AppointmentManagementConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.DateFormat.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("appointment-management")
public class AppointmentManagementController {

    @Autowired
    private AppointmentManagementService appointmentManagementService;

    @Autowired
    private AppointmentManagementConverter appointmentManagementConverter;

    @PostMapping("/create-appointment-management")
    public ResponseEntity<ResponseDTO> postAppointmentManagement(@RequestBody AppointmentManagementDTO appointmentManagementDTO){
        ResponseDTO responseDTO = this.appointmentManagementService.createAppointmentManagement(appointmentManagementDTO);
        return ResponseEntity.status(responseDTO.getStatusCode()).build();
    }

    @GetMapping("get-appointment-management-by-id/{identification}")
    public ResponseEntity<ResponseDTO> getAppointmentManagementByIdentification(@PathVariable String identification) {
        return ResponseEntity.ok(this.appointmentManagementService.getAppointmentManagementsByPatientId(identification));
    }

    @GetMapping("get-appointment-management-by-id-and-date/{identification}/{date}")
    public ResponseEntity<ResponseDTO> getAppointmentManagementByIdentificationAndDate(@PathVariable String identification, @PathVariable String date) throws ParseException {
        Date newDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        return ResponseEntity.ok(this.appointmentManagementService.getAppointmentManagementByPatientIdAndApptDt(identification, newDate));
    }

    @GetMapping("/list")
    public PageDTO<AppointmentManagementDTO> list(@RequestParam(value = "filter", required = false) String filter, @RequestParam(value = "orderBy", required = false) String orderby, @RequestParam(value = "sortOrder", required = false) String sortOrder, @RequestParam(value = "pageNumber") Integer pageNumber, @RequestParam(value = "pageSize") Integer pageSize){
        return appointmentManagementConverter.toPageDTO(appointmentManagementService.findAll(orderby, sortOrder, pageNumber, pageSize));
    }
}
