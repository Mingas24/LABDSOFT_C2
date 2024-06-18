package com.pt.isep.labdsoft.dto.domain;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransplantDonorListDTO {

    public String fullName;

    public String deathDate;

    public String harvestDate;

    public String category;

}
