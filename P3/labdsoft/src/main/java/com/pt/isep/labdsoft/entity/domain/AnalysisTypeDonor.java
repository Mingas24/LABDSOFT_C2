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
@Table(name = "DOM_ANALYSIS_TYPE_DONOR")
public class AnalysisTypeDonor extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "C_DONOR_ANALYSIS_REQUEST_PK", foreignKey = @ForeignKey(name = "FK_DAR_PK_2"))
    private DonorAnalysisRequest donorAnalysisRequest;

    @OneToOne
    @JoinColumn(name = "C_ANALYSIS_TYPE_PK", foreignKey = @ForeignKey(name = "FK_ANALYSIS_PK"))
    private AnalysisType analysisType;
}
