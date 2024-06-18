package com.pt.isep.labdsoft.repository;

import com.pt.isep.labdsoft.entity.domain.HealthActivityTracker;
import com.pt.isep.labdsoft.entity.domain.HealthActivityTrackerAssociation;
import com.pt.isep.labdsoft.entity.domain.TransplantRecipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthActivityTrackerAssociationRepository extends JpaRepository<HealthActivityTrackerAssociation, Long> {

    List<HealthActivityTrackerAssociation> findHealthActivityTrackerAssociationsByTransplantRecipientOrHealthActivityTracker(TransplantRecipient transplantRecipient, HealthActivityTracker healthActivityTracker);
    List<HealthActivityTrackerAssociation> findHealthActivityTrackerAssociationsByHealthActivityTracker(HealthActivityTracker healthActivityTracker);
}
