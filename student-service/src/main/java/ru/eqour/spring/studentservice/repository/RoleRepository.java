package ru.eqour.spring.studentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.eqour.spring.studentservice.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(String name);
}
