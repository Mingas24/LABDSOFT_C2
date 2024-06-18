package com.pt.isep.labdsoft.dto.auth;

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
public class UserDTO {

    private String username;

    private String email;

    private String password;

    private String fullName;

    private String phoneNumber;

    private String role;
}
