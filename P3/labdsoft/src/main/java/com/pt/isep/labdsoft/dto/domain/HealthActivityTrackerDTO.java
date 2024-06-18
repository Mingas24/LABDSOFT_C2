package com.pt.isep.labdsoft.dto.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HealthActivityTrackerDTO {

    private Long healthActivityTrackerId;
    private String transplantRecipientIdentification;
    private String protocol;
}
