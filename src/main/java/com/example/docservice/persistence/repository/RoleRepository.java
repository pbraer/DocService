package com.example.docservice.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.docservice.persistence.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
