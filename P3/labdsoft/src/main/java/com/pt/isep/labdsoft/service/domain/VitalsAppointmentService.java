package com.pt.isep.labdsoft.service.domain;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.VitalsAppointmentDTO;
import com.pt.isep.labdsoft.entity.domain.VitalsAppointment;
import org.springframework.data.domain.Page;

public interface VitalsAppointmentService {

    ResponseDTO createAppointment(VitalsAppointmentDTO vitalsAppointmentDTO);

    Page<VitalsAppointment> findAll(String ordery, String sortOrder, Integer pageNumber, Integer pageSize);
}
