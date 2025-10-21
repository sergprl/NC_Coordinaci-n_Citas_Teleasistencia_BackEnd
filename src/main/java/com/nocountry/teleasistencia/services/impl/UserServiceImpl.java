package com.nocountry.teleasistencia.services.impl;

import com.nocountry.teleasistencia.dto.request.UserRequestDto;
import com.nocountry.teleasistencia.dto.response.UserResponseDto;
import com.nocountry.teleasistencia.mapper.UserMapper;
import com.nocountry.teleasistencia.model.User;
import com.nocountry.teleasistencia.repository.UserRepository;
import com.nocountry.teleasistencia.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponseDto> findAll() {
        return userRepository.findAll().stream().map(
                userMapper::toResponse
        ).collect(Collectors.toList());
    }

    @Override
    public Optional<UserResponseDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public UserResponseDto save(UserRequestDto user) {
        return null;
    }

    @Override
    public boolean existsUsername(String username) {
        return false;
    }
//
//    private final UserRepository userRepository;
//
////    @Autowired
////    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public List<User> findAll() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    public Optional<User> findById(Long id) {
//        return userRepository.findById(id);
//    }
//
//    // TODO: Fix this! The role is now found within the user
//    @Override
//    public User save(User user) {
//
//        if( roleName.equalsIgnoreCase("PATIENT")){
//            optionalRole = roleRepository.findByName("PATIENT");
//        }else {
//            optionalRole = roleRepository.findByName("DOCTOR");
//        }
//        List<Role> roles = new ArrayList<>();
//        optionalRole.ifPresent(roles::add);
//
//        user.setCreated_at(LocalDate.now());
//
//        if (user.isAdmin()) {
//            Optional<Role> optionalRoleAdmin = roleRepository.findByName("ADMIN");
//            optionalRoleAdmin.ifPresent(roles::add);
//        }
////        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return userRepository.save(user);
//    }
//
//    @Override
//    public boolean existsUsername(String username) {
//        return userRepository.existsByEmail(username);
//    }
}
