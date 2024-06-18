package com.pt.isep.labdsoft.dto.domain;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InputSampleDTO {

    private String isRecipient;

    private String patientIdentification;

    private Date registrationDate;

    private String sampleIdentification;
}
