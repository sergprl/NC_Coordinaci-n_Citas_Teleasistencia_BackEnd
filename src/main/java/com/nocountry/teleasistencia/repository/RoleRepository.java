package com.nocountry.teleasistencia.repository;

import com.nocountry.teleasistencia.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface RoleRepository  extends CrudRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
