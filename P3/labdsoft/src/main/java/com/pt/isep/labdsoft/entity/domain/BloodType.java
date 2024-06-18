package com.pt.isep.labdsoft.entity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Table(name = "DOM_BLOOD_TYPE")
public class BloodType {

    @Id
    @Column(name = "C_PK", nullable = false)
    private Integer id;

    @Column(name = "C_DESCRIPTION", nullable = false)
    private String description;
}
