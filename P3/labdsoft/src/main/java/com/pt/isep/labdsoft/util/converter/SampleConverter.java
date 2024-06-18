package com.pt.isep.labdsoft.util.converter;

import com.pt.isep.labdsoft.dto.domain.InputSampleDTO;
import com.pt.isep.labdsoft.entity.domain.DonorSample;
import com.pt.isep.labdsoft.entity.domain.RecipientSample;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class SampleConverter {

    public Object toEntity(final InputSampleDTO inputSampleDTO) {
        if(inputSampleDTO.getIsRecipient().equals("Recipient")){
            return RecipientSample.builder()
                    .registrationDate(inputSampleDTO.getRegistrationDate())
                    .sampleIdentification(inputSampleDTO.getSampleIdentification())
                    .build();
        }
        return DonorSample.builder()
                .registrationDate(inputSampleDTO.getRegistrationDate())
                .sampleIdentification(inputSampleDTO.getSampleIdentification())
                .build();
    }

}