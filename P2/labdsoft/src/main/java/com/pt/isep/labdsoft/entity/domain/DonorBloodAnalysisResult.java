package com.pt.isep.labdsoft.entity.domain;

import com.pt.isep.labdsoft.entity.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DOM_DONOR_BLOOD_ANALYSIS_RESULT")
public class DonorBloodAnalysisResult extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "C_DONOR", nullable = false)
    private TransplantDonor donor;

    @OneToOne
    @JoinColumn(name = "C_DONOR_SAMPLE", nullable = false)
    private DonorSample donorSample;

    @Column(name = "C_ANALYSIS_DATE", nullable = false)
    private Date analysisDate;

    @Column(name = "C_IS_VALIDATED")
    private boolean isValidated;

    @OneToMany(mappedBy = "donorBloodAnalysisResult", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<BloodAnalysisDonor> bloodAnalysisDonor;

}

