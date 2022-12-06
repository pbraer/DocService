package com.example.docservice.persistence.repository;

import com.example.docservice.persistence.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID>{
    @Query(value = "SELECT * FROM patientsappoitm", nativeQuery = true)
    List<Client> findAllClients();
}