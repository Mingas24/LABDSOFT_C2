package com.pt.isep.labdsoft.dto.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VitalSignsDTO {

    private String healthTrackerIdentifier;

    private String bloodPressure;

    private String bloodPressureProtocol;

    private String bodyTemperature;

    private String bodyTemperatureProtocol;

    private String heartRate;

    private String heartRateProtocol;
}
