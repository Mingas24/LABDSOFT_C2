package com.pt.isep.labdsoft.service.domain;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.HealthActivityTrackerDTO;
import com.pt.isep.labdsoft.entity.domain.HealthActivityTracker;
import com.pt.isep.labdsoft.entity.domain.HealthActivityTrackerAssociation;
import com.pt.isep.labdsoft.entity.domain.TransplantRecipient;
import com.pt.isep.labdsoft.enums.StatusCode;
import com.pt.isep.labdsoft.repository.HealthActivityTrackerAssociationRepository;
import com.pt.isep.labdsoft.repository.HealthActivityTrackerRepository;
import com.pt.isep.labdsoft.repository.TransplantRecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class HealthActivityTrackerServiceImpl implements HealthActivityTrackerService {

    @Autowired
    private HealthActivityTrackerRepository healthActivityTrackerRepository;

    @Autowired
    private HealthActivityTrackerAssociationRepository healthActivityTrackerAssociationRepository;

    @Autowired
    private TransplantRecipientRepository transplantRecipientRepository;

    @Override
    public ResponseDTO associateHealthActivityTracker(HealthActivityTrackerDTO healthActivityTrackerDTO) {
        HealthActivityTracker healthActivityTracker;
        Optional<HealthActivityTracker> healthActivityTrackerOptional = this.healthActivityTrackerRepository
                .findHealthActivityTrackerByHealthActivityTrackerId(healthActivityTrackerDTO.getHealthActivityTrackerId());

        if (healthActivityTrackerOptional.isEmpty()) {
            healthActivityTracker = this.healthActivityTrackerRepository.save(new HealthActivityTracker(healthActivityTrackerDTO.getHealthActivityTrackerId()));
        } else {
            healthActivityTracker = healthActivityTrackerOptional.get();
        }

        Optional<TransplantRecipient> transplantRecipientOptional = this.transplantRecipientRepository
                .findTransplantRecipientByIdentification(healthActivityTrackerDTO.getTransplantRecipientIdentification());
        if (transplantRecipientOptional.isEmpty()) {
            return new ResponseDTO(false, "Transplant recipient not found", StatusCode.NOT_FOUND.getValue());
        }

        List<HealthActivityTrackerAssociation> hatAssociationList =
                this.healthActivityTrackerAssociationRepository
                        .findHealthActivityTrackerAssociationsByTransplantRecipientOrHealthActivityTracker(transplantRecipientOptional.get(), healthActivityTracker);

        if (hatAssociationList.isEmpty()) {
            HealthActivityTrackerAssociation healthActivityTrackerAssociation = HealthActivityTrackerAssociation.builder()
                    .healthActivityTracker(healthActivityTracker)
                    .transplantRecipient(transplantRecipientOptional.get())
                    .build();

            this.healthActivityTrackerAssociationRepository.save(healthActivityTrackerAssociation);

        } else if (hatAssociationList.size() == 1 && hatAssociationList.get(0).getTransplantRecipient().equals(transplantRecipientOptional.get())) {
            hatAssociationList.get(0).setHealthActivityTracker(healthActivityTracker);
            hatAssociationList.get(0).setTransplantRecipient(transplantRecipientOptional.get());
            this.healthActivityTrackerAssociationRepository.save(hatAssociationList.get(0));
        } else {
            return new ResponseDTO(false, "Health activity tracker is already associated to another transplant recipient or vice versa", StatusCode.OPERATION_EXCEPTION.getValue());
        }


        return new ResponseDTO(true, "Health Activity Tracker associated correctly", StatusCode.OK.getValue());
    }
}
