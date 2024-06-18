package com.pt.isep.labdsoft.entity.ui;

import com.pt.isep.labdsoft.entity.base.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Builder
@Entity
@Table(name = "UI_TEST")
public class UITest extends BaseEntity {

}
