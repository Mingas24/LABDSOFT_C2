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
@Table(name = "DOM_RECIPIENT_ANALYSIS_REQUEST")
public class RecipientAnalysisRequest extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "C_REQUESTED_BY", nullable = false)
    private User requestedBy;

    @OneToOne
    @JoinColumn(name = "C_RECIPIENT", nullable = false)
    private TransplantRecipient transplantRecipient;

    @OneToOne
    @JoinColumn(name = "C_RECIPIENT_SAMPLE", nullable = false)
    private RecipientSample recipientSample;

    @OneToMany(mappedBy = "recipientAnalysisRequest", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<AnalysisTypeRecipient> analysisTypeRecipients = new ArrayList<>();
}
