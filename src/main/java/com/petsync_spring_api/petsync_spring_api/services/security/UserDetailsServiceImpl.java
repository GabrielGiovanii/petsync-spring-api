package com.petsync_spring_api.petsync_spring_api.services.security;

import com.petsync_spring_api.petsync_spring_api.entities.User;
import com.petsync_spring_api.petsync_spring_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        Optional<User> userOptional = userService.findById(cpf);

        return  userOptional.map(UserAuth::new)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with cpf: " + cpf));
    }
}
