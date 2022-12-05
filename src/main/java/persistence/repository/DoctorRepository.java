package persistence.repository;
import persistence.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, UUID>{
    @Query(value = "SELECT * FROM doctors", nativeQuery = true)
    List<Doctor> findAllDoctors();
}