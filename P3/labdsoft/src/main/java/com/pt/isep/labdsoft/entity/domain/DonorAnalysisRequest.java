package com.pt.isep.labdsoft.entity.domain;

import com.pt.isep.labdsoft.entity.auth.User;
import com.pt.isep.labdsoft.entity.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "DOM_DONOR_ANALYSIS_REQUEST")
public class DonorAnalysisRequest extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "C_REQUESTED_BY", nullable = false)
    private User requestedBy;

    @OneToOne
    @JoinColumn(name = "C_DONOR", nullable = false)
    private TransplantDonor transplantDonor;

    @OneToOne
    @JoinColumn(name = "C_DONOR_SAMPLE", nullable = false)
    private DonorSample donorSample;

    @OneToMany(mappedBy = "donorAnalysisRequest", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<AnalysisTypeDonor> analysisTypeDonors = new ArrayList<>();
}
