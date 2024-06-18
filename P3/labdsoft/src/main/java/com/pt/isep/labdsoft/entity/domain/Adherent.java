package com.pt.isep.labdsoft.entity.domain;

import com.pt.isep.labdsoft.entity.base.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "DOM_ADHERENT")
public class Adherent extends BaseEntity {

    @Column(name = "C_FULL_NAME", nullable = false)
    private String fullName;

    @Column(name = "C_AGE", nullable = false)
    private String age;

    @Column(name = "C_NATIONALITY", nullable = false)
    private String nationality;

    @Column(name = "C_JOB", nullable = false)
    private String job;

    @Column(name = "C_CELEBRITY", nullable = false)
    private String celebrity;
}
