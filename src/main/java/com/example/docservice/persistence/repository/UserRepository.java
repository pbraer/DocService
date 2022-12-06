package com.example.docservice.persistence.repository;

import com.example.docservice.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM roletable", nativeQuery = true)
    User findByEmail(String email);
}

