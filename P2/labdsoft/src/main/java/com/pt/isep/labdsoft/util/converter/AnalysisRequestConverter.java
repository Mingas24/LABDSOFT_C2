package com.pt.isep.labdsoft.util.converter;

import com.pt.isep.labdsoft.entity.auth.User;
import com.pt.isep.labdsoft.entity.domain.*;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class AnalysisRequestConverter {

    public RecipientAnalysisRequest toEntityRecipient(final User user, final RecipientSample recipientSample, final TransplantRecipient transplantRecipient){
        return RecipientAnalysisRequest.builder()
                .requestedBy(user)
                .transplantRecipient(transplantRecipient)
                .recipientSample(recipientSample)
                .build();
    }

    public DonorAnalysisRequest toEntityDonor(final User user, final DonorSample donorSample, final TransplantDonor transplantDonor){
        return DonorAnalysisRequest.builder()
                .requestedBy(user)
                .transplantDonor(transplantDonor)
                .donorSample(donorSample)
                .build();
    }
}
