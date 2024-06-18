package com.pt.isep.labdsoft.entity.domain;

import com.pt.isep.labdsoft.entity.base.BaseEntity;
import lombok.*;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DOM_RECIPIENT_BLOOD_ANALYSIS_RESULT")
public class RecipientBloodAnalysisResult extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "C_RECIPIENT", nullable = false)
    private TransplantRecipient recipient;

    @OneToOne
    @JoinColumn(name = "C_RECIPIENT_SAMPLE", nullable = false)
    private RecipientSample recipientSample;

    @Column(name = "C_ANALYSIS_DATE", nullable = false)
    private Date analysisDate;

    @Column(name = "C_IS_VALIDATED")
    private boolean isValidated;

    @OneToMany(mappedBy = "recipientBloodAnalysisResult", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<BloodAnalysisRecipient> bloodAnalysisRecipient;

}
