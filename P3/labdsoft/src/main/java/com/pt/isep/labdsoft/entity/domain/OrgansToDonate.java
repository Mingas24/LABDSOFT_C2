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
@Table(name = "DOM_ORGANS_TO_DONATE")
public class OrgansToDonate extends BaseEntity {

    @OneToOne
    @JoinColumn(name =" C_TRANSPLANT_DONOR_PK", foreignKey = @ForeignKey(name = "FK_TD_PK_1"))
    private TransplantDonor transplantDonor;

    @OneToOne
    @JoinColumn(name = "C_ORGAN_TYPE_PK", foreignKey = @ForeignKey(name = "FK_OT_PK"))
    private OrganType organType;
}
