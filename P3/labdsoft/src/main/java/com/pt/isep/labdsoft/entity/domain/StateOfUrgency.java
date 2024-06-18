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
import java.util.Arrays;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "DOM_STATE_OF_URGENCY")
public class StateOfUrgency {

    @Id
    @Column(name = "C_PK", nullable = false)
    private Integer id;

    @Column(name = "C_DESCRIPTION", nullable = false)
    private String description;
}
