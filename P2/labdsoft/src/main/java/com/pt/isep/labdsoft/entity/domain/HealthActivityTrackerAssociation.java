package com.pt.isep.labdsoft.entity.domain;

import com.pt.isep.labdsoft.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "DOM_HEALTH_ACTIVITY_TRACKER_ASSOCIATION")
public class HealthActivityTrackerAssociation extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "C_TRANSPLANT_RECIPIENT_PK", foreignKey = @ForeignKey(name = "FK_TR_PK"))
    private TransplantRecipient transplantRecipient;

    @OneToOne
    @JoinColumn(name = "C_HEALTH_ACTIVITY_TRACKER_PK", foreignKey = @ForeignKey(name = "FK_HAT_PK"))
    private HealthActivityTracker healthActivityTracker;

}
