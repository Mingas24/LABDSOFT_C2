package com.pt.isep.labdsoft.service.domain;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.AppointmentDTO;
import com.pt.isep.labdsoft.entity.domain.Appointment;
import org.springframework.data.domain.Page;

public interface AppointmentService {

    ResponseDTO createAppointment(AppointmentDTO appointmentDTO);

    Page<Appointment> findAll(String ordery, String sortOrder, Integer pageNumber, Integer pageSize);
}
