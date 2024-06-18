package com.pt.isep.labdsoft.entity.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "DOM_ANALYSIS_TYPE")
public class AnalysisType {

    @Id
    @Column(name = "C_PK", nullable = false)
    private Integer id;

    @Column(name = "C_DESCRIPTION", nullable = false)
    private String description;
}
