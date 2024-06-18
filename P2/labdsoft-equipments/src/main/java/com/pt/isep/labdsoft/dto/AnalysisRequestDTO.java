package com.pt.isep.labdsoft.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnalysisRequestDTO {

    private String isRecipient;

    private String requestedBy;

    private String patientIdentification;

    private String sampleIdentification;

    private List<String> analysisTypes;
}
