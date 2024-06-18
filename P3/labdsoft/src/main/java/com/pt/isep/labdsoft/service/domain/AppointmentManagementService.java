package com.pt.isep.labdsoft.service.domain;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.AppointmentManagementDTO;
import com.pt.isep.labdsoft.entity.domain.AppointmentManagement;
import org.springframework.data.domain.Page;

import java.util.Date;

public interface AppointmentManagementService {

    ResponseDTO createAppointmentManagement(AppointmentManagementDTO appointmentManagementDTO);

    ResponseDTO getAppointmentManagementsByPatientId(String patientId);

    ResponseDTO getAppointmentManagementByPatientIdAndApptDt(String patientId, Date apptDt);

    Page<AppointmentManagement> findAll(String ordery, String sortOrder, Integer pageNumber, Integer pageSize);
}
