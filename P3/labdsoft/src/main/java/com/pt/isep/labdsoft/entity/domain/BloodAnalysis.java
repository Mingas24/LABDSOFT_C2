package com.pt.isep.labdsoft.entity.domain;

import com.pt.isep.labdsoft.entity.base.BaseEntity;
import lombok.*;

import java.util.List;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DOM_BLOOD_ANALYSIS")
public class BloodAnalysis extends BaseEntity{

    @Column(name = "C_BLOOD_ANALYSIS_METHOD")
    private String bloodAnalysisMethod;

    @Column(name = "C_ANALYSIS_RESULT_VALUE")
    private String analysisResultValue;

    @Column(name = "C_ANALYSIS_RESULT")
    private String analysisResult;

}
