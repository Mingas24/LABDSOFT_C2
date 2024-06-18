package com.pt.isep.labdsoft.util.converter;

import com.pt.isep.labdsoft.dto.auth.UserDTO;
import com.pt.isep.labdsoft.entity.auth.User;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class UserConverter {

    public User toEntity(final UserDTO userDTO) {
        return User.builder()
                .username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .fullName(userDTO.getFullName())
                .phoneNumber(userDTO.getPhoneNumber())
                .build();
    }

    public UserDTO toDTO(final User user) {
        return UserDTO.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .phoneNumber(user.getPhoneNumber())
                .role(user.getRole().getDescription())
                .build();
    }
}
