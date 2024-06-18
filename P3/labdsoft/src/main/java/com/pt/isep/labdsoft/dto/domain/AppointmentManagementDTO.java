package com.pt.isep.labdsoft.dto.domain;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentManagementDTO {

    private String appointmentManagementDescription;

    private String medic;

    private String patientId;

    private Date appointmentManagementDate;
}
