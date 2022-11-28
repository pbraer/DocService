package com.example.docservice.repository;
import com.example.docservice.entity.ProfileDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DocRepository extends JpaRepository<ProfileDoc, UUID>{
    @Query(value = "SELECT * FROM doctors", nativeQuery = true)
    List<ProfileDoc> findAllDoctors();
}