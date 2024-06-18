package com.pt.isep.labdsoft.util.converter;

import com.pt.isep.labdsoft.dto.PageDTO;
import com.pt.isep.labdsoft.dto.domain.VitalsAppointmentDTO;
import com.pt.isep.labdsoft.entity.domain.VitalsAppointment;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@NoArgsConstructor
@Component
public class VitalsAppointmentConverter {

    public VitalsAppointment toEntity(final VitalsAppointmentDTO vitalsAppointmentDTO){
        return VitalsAppointment.builder()
                .vitalsAppointmentDescription(vitalsAppointmentDTO.getVitalsAppointmentDescription())
                .build();
    }

    public VitalsAppointmentDTO toDTO(final VitalsAppointment vitalsAppointment){
        return VitalsAppointmentDTO.builder()
                .vitalsAppointmentDescription(vitalsAppointment.getVitalsAppointmentDescription())
                .registeredBy(vitalsAppointment.getMedic().getUsername())
                .build();
    }

    public PageDTO<VitalsAppointmentDTO> toPageDTO(Page<VitalsAppointment> vitalsAppointment){
        List<VitalsAppointmentDTO> list = vitalsAppointment.getContent().stream().map(e -> toDTO(e)).collect(Collectors.toList());
        return new PageDTO<VitalsAppointmentDTO>(
                list,
                vitalsAppointment.getNumber(),
                vitalsAppointment.getSize(),
                vitalsAppointment.getTotalElements(),
                vitalsAppointment.getTotalPages()
        );
    }
}
