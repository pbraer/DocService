package persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "Client")
public class Client {
    @Id
    private UUID id;

    @Column(name = "email")
    private String email;

    private String spec;
    private String doctor;
    private String date;
    private String time;
}