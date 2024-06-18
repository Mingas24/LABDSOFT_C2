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
@Table(name = "DOM_HLA_TRANSPLANT_DONOR")
public class HLATransplantDonor extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "C_TRANSPLANT_DONOR_PK", foreignKey = @ForeignKey(name = "FK_TD_PK_2"))
    private TransplantDonor transplantDonor;

    @OneToOne
    @JoinColumn(name =" C_HLA_TYPE_PK", foreignKey = @ForeignKey(name = "FK_HLAT_PK"))
    private HLAType hlaType;

}
