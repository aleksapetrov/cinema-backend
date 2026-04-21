package dev_practice.cinema_backend.repository;

import dev_practice.cinema_backend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
