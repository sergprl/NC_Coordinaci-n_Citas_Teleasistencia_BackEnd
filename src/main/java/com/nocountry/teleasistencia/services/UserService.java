package com.nocountry.teleasistencia.services;

import com.nocountry.teleasistencia.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User user, String role);

    boolean existsUsername(String username);
}
