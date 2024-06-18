package com.pt.isep.labdsoft.entity.domain;

import com.pt.isep.labdsoft.entity.base.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "DOM_VITAL_SIGNS")
public class VitalSigns extends BaseEntity {

    @Column(name = "C_HEALTH_TRACKER_IDENTIFIER", nullable = false)
    private String healthTrackerIdentifier;

    @Column(name = "C_BLOOD_PRESSURE", nullable = false)
    private String bloodPressure;

    @Column(name = "C_BODY_TEMPERATURE", nullable = false)
    private String bodyTemperature;

    @Column(name = "C_HEART_RATE", nullable = false)
    private String heartRate;

    @Column(name = "C_STABILITY", nullable = false)
    private String stability;
}
