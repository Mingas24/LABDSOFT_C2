package com.pt.isep.labdsoft.util.converter;

import com.pt.isep.labdsoft.dto.PageDTO;
import com.pt.isep.labdsoft.dto.domain.AppointmentDTO;
import com.pt.isep.labdsoft.entity.domain.Appointment;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@NoArgsConstructor
@Component
public class AppointmentConverter {

    public Appointment toEntity(final AppointmentDTO appointmentDTO){
        return Appointment.builder()
                .appointmentDescription(appointmentDTO.getAppointmentDescription()).build();
    }

    public AppointmentDTO toDTO(final Appointment appointment){
        return AppointmentDTO.builder()
                .appointmentDescription(appointment.getAppointmentDescription())
                .registeredBy(appointment.getMedic().getUsername())
                .registryDate(appointment.getCreatedDt().toString()).build();
    }

    public PageDTO<AppointmentDTO> toPageDTO(Page<Appointment> appointment){
        List<AppointmentDTO> list = appointment.getContent().stream().map(e -> toDTO(e)).collect(Collectors.toList());
        return new PageDTO<AppointmentDTO>(
                list,
                appointment.getNumber(),
                appointment.getSize(),
                appointment.getTotalElements(),
                appointment.getTotalPages()
        );
    }
}
