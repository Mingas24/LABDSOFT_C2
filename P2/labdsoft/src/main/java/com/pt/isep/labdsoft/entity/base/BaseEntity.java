package com.pt.isep.labdsoft.entity.base;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public class BaseEntity {

    @Id
    @Column(name = "C_PK")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
    private Long pk;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "C_CREATED")
    @CreatedDate
    private Date createdDt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "C_UPDATED")
    @LastModifiedDate
    private Date lastModifiedDt;

    protected BaseEntity() {
    }

}
