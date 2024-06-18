package com.pt.isep.labdsoft.entity.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "DOM_PROTOCOL")
public class Protocol {

    @Id
    @Column(name = "C_PK", nullable = false)
    private Long id;

    @Column(name = "C_PROTOCOL", nullable = false)
    private String protocol;

    @Column(name = "C_BLOOD_PRESSURE", nullable = false)
    private String bloodPressure;

    @Column(name = "C_BODY_TEMPERATURE", nullable = false)
    private String bodyTemperature;

    @Column(name = "C_HEART_RATE", nullable = false)
    private String heartRate;
}
