package com.pt.isep.labdsoft.entity.domain;

import com.pt.isep.labdsoft.entity.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DOM_BLOOD_ANALYSIS_RECIPIENT")
public class BloodAnalysisRecipient extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "C_RECIPIENT_BLOOD_ANALYSIS_RESULT_PK", foreignKey = @ForeignKey(name = "FK_RBAR_PK_2"))
    private RecipientBloodAnalysisResult recipientBloodAnalysisResult;

    /*@OneToOne
    @JoinColumns({
            @JoinColumn(name = "C_BLOOD_ANALYSIS_PK", foreignKey = @ForeignKey(name = "FK_BA_PK_2")),
            @JoinColumn(name = "C_BLOOD_ANALYSIS_METHOD_PK", foreignKey = @ForeignKey(name = "FK_BAM_PK_2"))
    })
    private BloodAnalysis bloodAnalysis;*/

    @OneToOne
    @JoinColumn(name = "C_BLOOD_ANALYSIS_PK", foreignKey = @ForeignKey(name = "FK_BA_PK_2"))
    private BloodAnalysis bloodAnalysis;
}
