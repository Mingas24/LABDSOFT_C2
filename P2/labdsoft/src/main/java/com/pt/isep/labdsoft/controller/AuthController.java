package com.pt.isep.labdsoft.controller;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.auth.UserDTO;
import com.pt.isep.labdsoft.enums.StatusCode;
import com.pt.isep.labdsoft.security.jwt.AuthResponse;
import com.pt.isep.labdsoft.security.jwt.AuthRequest;
import com.pt.isep.labdsoft.security.jwt.JwtTokenUtil;
import com.pt.isep.labdsoft.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = this.userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final UserDTO userDTO = (UserDTO) this.userService.getUserByUsername(authenticationRequest.getUsername()).getResponseObject();

        final String token = this.jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new ResponseDTO(true, new AuthResponse(token, userDTO), StatusCode.OK.getValue()));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
