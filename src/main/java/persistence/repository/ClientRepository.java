package persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import persistence.entity.Client;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID>{
    @Query(value = "SELECT * FROM clients", nativeQuery = true)
    List<Client> findAllClients();
}