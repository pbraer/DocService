package com.example.docservice.persistence.repository;

import com.example.docservice.persistence.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
    @Query(value = "SELECT * FROM doctors", nativeQuery = true)
    List<Doctor> findAllDoctors();
}