package com.pt.isep.labdsoft.dto.domain;

import com.pt.isep.labdsoft.entity.domain.VitalSigns;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VitalsAppointmentDTO {

    private String vitalsAppointmentDescription;

    private String registeredBy;

    private String fullName;

    private String healthTrackerIdentifier;

    private String bloodPressure;

    private String bodyTemperature;

    private String heartRate;
}
