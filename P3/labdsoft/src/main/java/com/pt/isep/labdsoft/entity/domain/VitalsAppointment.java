package com.pt.isep.labdsoft.entity.domain;

import com.pt.isep.labdsoft.entity.auth.User;
import com.pt.isep.labdsoft.entity.base.BaseEntity;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "DOM_VITALS_APPOINTMENT")
public class VitalsAppointment extends BaseEntity {

    @Column(name = "C_APPT_DESCRIPTION")
    private String vitalsAppointmentDescription;

    @OneToOne
    @JoinColumn(name = "C_MEDIC")
    private User medic;

    @OneToOne
    @JoinColumn(name = "C_PATIENT")
    private TransplantRecipient patient;

}
