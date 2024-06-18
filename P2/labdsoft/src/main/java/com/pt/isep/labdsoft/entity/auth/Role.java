package com.pt.isep.labdsoft.entity.auth;

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
@Table(name = "AUTH_ROLE")
public class Role {

    @Id
    @Column(name = "C_PK", nullable = false)
    private Long id;

    @Column(name = "C_DESCRIPTION", nullable = false)
    private String description;
}
