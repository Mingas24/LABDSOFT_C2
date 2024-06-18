package com.pt.isep.labdsoft.dto.domain;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentDTO {

    private String appointmentDescription;

    private String registeredBy;

    private String fullName;

    private String registryDate;
}
