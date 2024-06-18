package com.pt.isep.labdsoft.entity.domain;

import com.pt.isep.labdsoft.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "DOM_HLA_TRANSPLANT_RECIPIENT")
public class HLATransplantRecipient extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "C_TRANSPLANT_RECIPIENT_PK", foreignKey = @ForeignKey(name = "FK_TR_PK_2"))
    private TransplantRecipient transplantRecipient;

    @OneToOne
    @JoinColumn(name = "C_HLA_TYPE_PK", foreignKey = @ForeignKey(name = "FK_HLAT_PK"))
    private HLAType hlaType;
}
