package com.pt.isep.labdsoft.security.jwt;

import com.pt.isep.labdsoft.dto.auth.UserDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class AuthResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -8091879091924046844L;
    private final String token;
    private final UserDTO user;

    public AuthResponse(String token, UserDTO user) {
        this.token = token;
        this.user = user;
    }

}
