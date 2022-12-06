package com.example.docservice.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.docservice.persistence.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
