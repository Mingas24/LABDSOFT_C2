package com.pt.isep.labdsoft.security.service;

import com.pt.isep.labdsoft.entity.auth.User;
import com.pt.isep.labdsoft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthUserServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public AuthUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Optional<User> optionalUser = userRepository.findByUsername(username);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority(user.getRole().getDescription()));

                return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                        authorities);
            }
        } catch (Exception ex) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return null;
    }
}
