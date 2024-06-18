package com.pt.isep.labdsoft.dto.domain;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransplantDonorDTO {

    public String fullName;

    public Date deathDate;

    public Date harvestDate;

    public String category;

    public String bloodType;

    private List<String> hlaTypes;

    public List<String> organsToDonate;

}
