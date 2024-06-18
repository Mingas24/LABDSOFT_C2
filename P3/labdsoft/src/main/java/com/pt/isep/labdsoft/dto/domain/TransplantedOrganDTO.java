package com.pt.isep.labdsoft.dto.domain;

import java.util.Date;

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
public class TransplantedOrganDTO {

    public String fullName;
    public String transplantedOrgan;
    public Date transplantationDate;
    
}
