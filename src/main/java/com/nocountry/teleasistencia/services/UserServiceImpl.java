package com.nocountry.teleasistencia.services;

import com.nocountry.teleasistencia.model.Role;
import com.nocountry.teleasistencia.model.User;
import com.nocountry.teleasistencia.repository.RoleRepository;
import com.nocountry.teleasistencia.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user, String roleName) {
        Optional<Role> optionalRole;
        if( roleName.equalsIgnoreCase("PATIENT")){
            optionalRole = roleRepository.findByName("PATIENT");
        }else {
            optionalRole = roleRepository.findByName("DOCTOR");
        }
        List<Role> roles = new ArrayList<>();
        optionalRole.ifPresent(roles::add);

        user.setCreated_at(LocalDate.now());

        if (user.isAdmin()) {
            Optional<Role> optionalRoleAdmin = roleRepository.findByName("ADMIN");
            optionalRoleAdmin.ifPresent(roles::add);
        }
        user.setRoles(roles);
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public boolean existsUsername(String username) {
        return userRepository.existsByEmail(username);
    }
}
