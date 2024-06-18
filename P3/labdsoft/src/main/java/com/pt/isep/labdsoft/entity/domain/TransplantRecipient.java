package com.pt.isep.labdsoft.entity.domain;

import com.pt.isep.labdsoft.entity.auth.User;
import com.pt.isep.labdsoft.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "DOM_TRANSPLANT_RECIPIENT")
public class TransplantRecipient extends BaseEntity {

    @Column(name = "C_REGISTRATION_DATE", nullable = false)
    private Date registrationDate;

    @OneToOne
    @JoinColumn(name = "C_REGISTERED_BY", nullable = false)
    private User registeredBy;

    @OneToMany(mappedBy = "transplantRecipient", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<OrgansInNeed> organsInNeed = new ArrayList<>();

    @Column(name = "C_FULL_NAME", nullable = false)
    private String fullName;

    @Column(name = "C_ADDRESS", nullable = false)
    private String address;

    @Column(name = "C_DATE_OF_BIRTH", nullable = false)
    private Date dateOfBirth;

    @Column(name = "C_IDENTIFICATION", nullable = false)
    private String identification;

    @Column(name = "C_NATIONALITY", nullable = false)
    private String nationality;

    @Column(name = "C_IMC", nullable = false)
    private String imc;

    @OneToOne
    @JoinColumn(name = "C_ASSISTENT_DOCTOR", nullable = false)
    private User assistentDoctor;

    @OneToOne
    @JoinColumn(name = "C_STATE_OF_URGENCY", nullable = false)
    private StateOfUrgency stateOfUrgency;

    @Column(name = "C_STATE_OF_URGENCY_DATE", nullable = false)
    private Date stateOfUrgencyDate;

    @OneToOne
    @JoinColumn(name = "C_BLOOD_TYPE", nullable = false)
    private BloodType bloodType;

    @OneToMany(mappedBy = "transplantRecipient", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<HLATransplantRecipient> hlasTransplantRecipient = new ArrayList<>();

    /**
     * TODO:
     * Análises víricas, Transplantes anteriores
     * */



}
