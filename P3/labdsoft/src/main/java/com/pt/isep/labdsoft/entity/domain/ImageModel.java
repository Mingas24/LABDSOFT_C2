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
@Table(name = "DOM_IMAGE")
public class ImageModel extends BaseEntity {

    @Column(name = "C_NAME")
    private String name;

    @Column(name = "C_TYPE")
    private String type;

    @Column(name = "C_PICBYTE")
    private byte[] picByte;

}
