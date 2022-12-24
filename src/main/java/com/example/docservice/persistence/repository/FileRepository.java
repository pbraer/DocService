package com.example.docservice.persistence.repository;

import com.example.docservice.persistence.entity.ClientFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<ClientFiles, Long> {
    @Query(value = "SELECT * FROM documents", nativeQuery = true)
    List<ClientFiles> findAllFiles();

}

