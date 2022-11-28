package com.example.docservice.repository;
import com.example.docservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID>{
    @Query(value = "SELECT * FROM doctors", nativeQuery = true)
    List<Account> findAllDoctors();
}