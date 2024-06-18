package com.pt.isep.labdsoft.entity.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pt.isep.labdsoft.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = " DOM_TRANSPLANTED_ORGAN")
public class TransplantedOrgan extends BaseEntity {

    @Column(name = "C_FULL_NAME", nullable = false)
    private String fullName;

    @Column(name = "C_TRANSPLANTED_ORGAN", nullable = false)
    private String transplantedOrgan;

    @Column(name = "C_TRANSPLANTATION_DATE", nullable = false)
    private Date transplantationDate;
}
