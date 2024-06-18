package com.pt.isep.labdsoft.entity.auth;

import com.pt.isep.labdsoft.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "AUTH_USER")
public class User extends BaseEntity {

    @Column(name = "C_USERNAME", nullable = false)
    private String username;

    @Column(name = "C_EMAIL")
    private String email;

    @Column(name = "C_PASSWORD", nullable = false)
    private String password;

    @Column(name = "C_FULL_NAME", nullable = false)
    private String fullName;

    @Column(name = "C_PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "C_ROLE", nullable = false)
    private Role role;
}
