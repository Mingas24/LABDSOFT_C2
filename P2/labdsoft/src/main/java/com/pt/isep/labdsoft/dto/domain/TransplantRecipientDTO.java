package com.pt.isep.labdsoft.dto.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransplantRecipientDTO {

    private Date registrationDate;

    private String registeredBy;

    private List<String> organsInNeed;

    private String fullName;

    private String address;

    private Date dateOfBirth;

    private String identification;

    private String nationality;

    private String imc;

    private String assistentDoctor;

    private String stateOfUrgency;

    private Date stateOfUrgencyDate;

    private String bloodType;

    private List<String> hlaTypes;
}
