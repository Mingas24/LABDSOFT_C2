package com.pt.isep.labdsoft.dto.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateRecipientUrgencyStatusDTO {

    private String fullName;

    private String stateOfUrgency;
}
