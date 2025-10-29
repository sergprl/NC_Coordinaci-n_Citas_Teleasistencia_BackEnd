package com.nocountry.teleasistencia.services.impl;

import com.nocountry.teleasistencia.model.User;
import com.nocountry.teleasistencia.repository.UserRepository;
import com.nocountry.teleasistencia.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Primary
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Couldn't find username " + username));

        return new UserPrincipal(user);
    }
}
