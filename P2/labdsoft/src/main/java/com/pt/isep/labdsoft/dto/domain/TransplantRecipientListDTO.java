package com.pt.isep.labdsoft.dto.domain;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransplantRecipientListDTO {

    private String registrationDate;

    private String fullName;

    private String dateOfBirth;

    private String indentification;

    private String nationality;

    private String stateOfUrgency;

    private String stateOfUrgenyDate;

    private String bloodType;

}
