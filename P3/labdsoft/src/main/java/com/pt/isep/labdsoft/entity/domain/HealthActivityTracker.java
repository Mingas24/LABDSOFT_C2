package com.pt.isep.labdsoft.entity.domain;

import com.pt.isep.labdsoft.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "DOM_HEALTH_ACTIVITY_TRACKER")
public class HealthActivityTracker extends BaseEntity {

    @Column(name = "C_HEALTH_ACTIVITY_TRACKER_ID", nullable = false)
    private Long healthActivityTrackerId;
}
