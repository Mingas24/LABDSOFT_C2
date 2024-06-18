package com.pt.isep.labdsoft.entity.domain;

import com.pt.isep.labdsoft.entity.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "DOM_TRANSPLANT_DONOR")
public class TransplantDonor extends BaseEntity {

    @Column(name = "C_FULL_NAME", nullable = false)
    private String fullName;

    @Column(name = "C_DEATH_DATE", nullable = false)
    private Date deathDate;

    @Column(name = "C_HARVEST_DATE", nullable = false)
    private Date harvestDate;

    @Column(name = "C_CATEGORY", nullable = false)
    private String category;

    @OneToOne
    @JoinColumn(name = "C_BLOOD_TYPE", nullable = false)
    private BloodType bloodType;

    @OneToMany(mappedBy = "transplantDonor", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<HLATransplantDonor> hlasTransplantDonor = new ArrayList<>();

    @OneToMany(mappedBy = "transplantDonor", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<OrgansToDonate> organsToDonates = new ArrayList<>();


    /**
     * TODO:
     * Análises víricas
     */
}
