package com.pt.isep.labdsoft.entity.domain;

import com.pt.isep.labdsoft.entity.auth.User;
import com.pt.isep.labdsoft.entity.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "DOM_APPOINTMENT_MANAGEMENT")
public class AppointmentManagement extends BaseEntity {

    @Column(name = "C_APPT_DESCRIPTION")
    private String appointmentManagementDescription;

    @Column(name = "C_APPT_DATE", nullable = false)
    private Date appointmentManagementDate;

    @OneToOne
    @JoinColumn(name = "C_MEDIC_PK", foreignKey = @ForeignKey(name = "FK_MEDIC_PK"))
    private User medic;

    @OneToOne
    @JoinColumn(name = "C_PATIENT_PK", foreignKey = @ForeignKey(name = "FK_PATIENT_PK"))
    private TransplantRecipient patient;
}
