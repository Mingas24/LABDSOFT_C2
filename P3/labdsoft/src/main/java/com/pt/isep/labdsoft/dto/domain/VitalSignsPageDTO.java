package com.pt.isep.labdsoft.dto.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VitalSignsPageDTO {

    private String healthTrackerIdentifier;

    private String bloodPressure;

    private String bodyTemperature;

    private String heartRate;

    private String stability;
}
