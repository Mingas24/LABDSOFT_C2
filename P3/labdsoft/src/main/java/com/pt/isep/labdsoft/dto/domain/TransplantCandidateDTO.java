package com.pt.isep.labdsoft.dto.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransplantCandidateDTO {

    public String fullName;

    public String points;

    public String bloodType;

    public String organForTransplant;

    public String urgencyState;
}