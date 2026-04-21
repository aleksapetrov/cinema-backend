package dev_practice.cinema_backend.repository;

import dev_practice.cinema_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
