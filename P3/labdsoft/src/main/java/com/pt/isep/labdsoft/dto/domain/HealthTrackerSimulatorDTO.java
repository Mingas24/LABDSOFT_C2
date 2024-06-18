package com.pt.isep.labdsoft.dto.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HealthTrackerSimulatorDTO {

    private String healthTrackerIdentifier;

    private String bloodPressure;

    private String bodyTemperature;

    private String heartRate;

    private String currentUser;
}
