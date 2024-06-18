package com.pt.isep.labdsoft.service.auth;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.auth.UserDTO;
import com.pt.isep.labdsoft.dto.ui.UIUsersFormDataDTO;
import com.pt.isep.labdsoft.entity.auth.Role;
import com.pt.isep.labdsoft.entity.auth.User;
import com.pt.isep.labdsoft.enums.StatusCode;
import com.pt.isep.labdsoft.repository.RoleRepository;
import com.pt.isep.labdsoft.repository.UserRepository;
import com.pt.isep.labdsoft.util.converter.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public ResponseDTO createUser(UserDTO userDTO) {
        try {
            Optional<User> userOptional = this.userRepository.findByUsername(userDTO.getUsername());
            if(userOptional.isPresent()) {
                return new ResponseDTO(false, "User already exists", StatusCode.ALREADY_EXISTS.getValue());
            }

            Optional<Role> roleOptional = this.roleRepository.findRoleById(Long.parseLong(userDTO.getRole()));
            if(roleOptional.isEmpty()) {
                return new ResponseDTO(false, "Role not found", StatusCode.NOT_FOUND.getValue());
            }

            User user = this.userConverter.toEntity(userDTO);
            user.setRole(roleOptional.get());
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            this.userRepository.save(user);

        } catch (Exception ex) {
            return new ResponseDTO(false, ex.getMessage(), StatusCode.OPERATION_EXCEPTION.getValue());
        }

        return new ResponseDTO(true, "", StatusCode.CREATED.getValue());
    }

    @Override
    public ResponseDTO getUserByUsername(String username) {
        Optional<User> userOptional = this.userRepository.findByUsername(username);
        return userOptional.map(user ->
                new ResponseDTO(true, this.userConverter.toDTO(user), StatusCode.OK.getValue()))
                .orElseGet(() -> new ResponseDTO(false, "User not found", StatusCode.NOT_FOUND.getValue()));

    }

    @Override
    public ResponseDTO getUsersByRole(String roleDescription) {
        return new ResponseDTO(true, this.userRepository.findUsersByRoleDescription(roleDescription).stream().map(this.userConverter::toDTO).toList(), StatusCode.OK.getValue());
    }

    @Override
    public ResponseDTO getUsers() {
        List<String> users = this.userRepository.findAll().stream().map(User::getFullName).toList();
        return new ResponseDTO(true, UIUsersFormDataDTO.builder().users(users).build(), StatusCode.OK.getValue());
    }


}
