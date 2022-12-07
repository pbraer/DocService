package com.example.docservice.persistence.repository;

import com.example.docservice.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM usertable", nativeQuery = true)
    List<User>  findAllUsers();
    List<User>  findByEmail(String email);
    Boolean findByIsdoc();

}

