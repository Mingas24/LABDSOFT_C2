package com.pt.isep.labdsoft.util.converter;

import com.pt.isep.labdsoft.entity.domain.OrganType;
import com.pt.isep.labdsoft.entity.domain.OrganWastage;
import com.pt.isep.labdsoft.entity.domain.TransplantDonor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class OrganWastageConverter {

    public OrganWastage toEntity(final OrganType organType, final TransplantDonor transplantDonor){
        return OrganWastage.builder()
                .organType(organType)
                .donor(transplantDonor)
                .build();
    }
}
