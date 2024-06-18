package com.pt.isep.labdsoft.util.converter;

import com.pt.isep.labdsoft.dto.PageDTO;
import com.pt.isep.labdsoft.dto.domain.AppointmentManagementDTO;
import com.pt.isep.labdsoft.entity.domain.AppointmentManagement;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@NoArgsConstructor
@Component
public class AppointmentManagementConverter {

    public AppointmentManagement toEntity(final AppointmentManagementDTO appointmentManagementDTO){
        return AppointmentManagement.builder()
                .appointmentManagementDescription(appointmentManagementDTO.getAppointmentManagementDescription())
                .appointmentManagementDate(appointmentManagementDTO.getAppointmentManagementDate()).build();
    }

    public AppointmentManagementDTO toDTO(final AppointmentManagement appointmentManagement){
        return AppointmentManagementDTO.builder()
                .appointmentManagementDescription(appointmentManagement.getAppointmentManagementDescription())
                .medic(appointmentManagement.getMedic().getUsername())
                .appointmentManagementDate(appointmentManagement.getAppointmentManagementDate())
                .patientId(appointmentManagement.getPatient().getIdentification()).build();
    }

    public PageDTO<AppointmentManagementDTO> toPageDTO(Page<AppointmentManagement> appointmentManagement){
        List<AppointmentManagementDTO> list = appointmentManagement.getContent().stream().map(e -> toDTO(e)).collect(Collectors.toList());
        return new PageDTO<AppointmentManagementDTO>(
                list,
                appointmentManagement.getNumber(),
                appointmentManagement.getSize(),
                appointmentManagement.getTotalElements(),
                appointmentManagement.getTotalPages()
        );
    }
}
