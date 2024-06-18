package com.pt.isep.labdsoft.controller;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.auth.UserDTO;
import com.pt.isep.labdsoft.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ResponseDTO> postUser(@RequestBody UserDTO userDTO) {
        ResponseDTO responseDTO = this.userService.createUser(userDTO);
        return ResponseEntity.status(responseDTO.getStatusCode()).build();
    }

    @GetMapping(value = "/get-current-user")
    public ResponseEntity<ResponseDTO> getCurrentUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        return ResponseEntity.ok(this.userService.getUserByUsername(userDetails.getUsername()));
    }

    @GetMapping(value = "/get-current-user-name")
    public String getCurrentUserName() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        return userDetails.getUsername();
    }

    @GetMapping(value = "/get-users-by-role", params = {"roleDescription"})
    public ResponseEntity<ResponseDTO> getUsersByRole(@RequestParam("roleDescription") String roleDescription) {
        return ResponseEntity.ok(this.userService.getUsersByRole(roleDescription));
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> getUsers(){
        return ResponseEntity.ok(this.userService.getUsers());
    }
}
