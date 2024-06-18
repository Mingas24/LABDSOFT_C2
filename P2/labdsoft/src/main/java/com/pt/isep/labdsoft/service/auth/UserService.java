package com.pt.isep.labdsoft.service.auth;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.auth.UserDTO;

public interface UserService {

    ResponseDTO createUser(UserDTO userDTO);

    ResponseDTO getUserByUsername(String username);

    ResponseDTO getUsersByRole(String roleDescription);

    ResponseDTO getUsers();
}
