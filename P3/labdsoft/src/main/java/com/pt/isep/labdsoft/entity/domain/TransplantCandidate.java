package com.pt.isep.labdsoft.entity.domain;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "DOM_TRANSPLANT_CANDIDATE")
public class TransplantCandidate {

    @Id
    @Column(name = "C_PK", nullable = false)
    private Long id;

    @Column(name = "C_FULL_NAME", nullable = false)
    private String fullName;

    @Column(name = "C_POINTS", nullable = false)
    private String points;

    @Column(name = "C_BLOOD_TYPE", nullable = false)
    private String bloodType;

    @Column(name = "C_ORGAN_FOR_TRANSPLANT", nullable = false)
    private String organForTransplant;

    @Column(name = "C_URGENCY_STATE", nullable = false)
    private String urgencyState;
}
