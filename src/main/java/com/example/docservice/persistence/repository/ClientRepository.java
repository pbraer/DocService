package com.example.docservice.persistence.repository;

import com.example.docservice.persistence.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    @Query(value = "SELECT * FROM patientsappoitm", nativeQuery = true)
    List<Client> findAllClients();
}