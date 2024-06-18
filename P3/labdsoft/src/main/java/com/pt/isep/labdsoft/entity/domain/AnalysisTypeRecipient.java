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
@Table(name = "DOM_ANALYSIS_TYPE_RECIPIENT")
public class AnalysisTypeRecipient extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "C_RECIPIENT_ANALYSIS_REQUEST_PK", foreignKey = @ForeignKey(name = "FK_RAR_PK_2"))
    private RecipientAnalysisRequest recipientAnalysisRequest;

    @OneToOne
    @JoinColumn(name = "C_ANALYSIS_TYPE_PK", foreignKey = @ForeignKey(name = "FK_ANALYSIS_PK"))
    private AnalysisType analysisType;
}
