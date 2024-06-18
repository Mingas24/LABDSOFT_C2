package com.pt.isep.labdsoft.entity.domain;

import com.pt.isep.labdsoft.entity.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "DOM_RECIPIENT_SAMPLE")
public class RecipientSample extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "C_RECIPIENT", nullable = false)
    private TransplantRecipient recipient;

    @Column(name = "C_REGISTRATION_DATE", nullable = false)
    private Date registrationDate;

    @Column(name = "C_SAMPLE_IDENTIFICATION", nullable = false)
    private String sampleIdentification;
}