package com.pt.isep.labdsoft.entity.domain;

import com.pt.isep.labdsoft.entity.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "DOM_ORGAN_WASTAGE")
public class OrganWastage  extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "C_ORGAN_TYPE", nullable = false)
    private OrganType organType;

    @OneToOne
    @JoinColumn(name = "C_DONOR", nullable = false)
    private TransplantDonor donor;

}
