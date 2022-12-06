package com.example.docservice.service;

import org.springframework.stereotype.Service;
import com.example.docservice.dto.ClientDto;
import com.example.docservice.persistence.entity.Client;
import com.example.docservice.persistence.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository userRepository) {
        this.clientRepository = userRepository;
    }

    public List<ClientDto> createClient(ClientDto clientDto) {
        Client student = new Client();
        student.setId(UUID.randomUUID());
        student.setSpec(clientDto.getSpec());
        student.setDoctor(clientDto.getDoctor());
        student.setDate(clientDto.getDate());
        student.setTime(clientDto.getTime());

        clientRepository.save(student);

        return getAllStudents();
    }

    public List<ClientDto> getAllStudents() {
        List<Client> clients = clientRepository.findAllClients();
        List<ClientDto> resultList = new ArrayList<>();
        for (Client client : clients) {
            ClientDto clientDto = new ClientDto();
            clientDto.setId(Long.parseLong(client.getId().toString()));
            clientDto.setSpec(client.getSpec());
            clientDto.setDoctor(client.getDoctor());
            clientDto.setDate(client.getDate());
            clientDto.setTime(client.getTime());
            resultList.add(clientDto);
        }

        return resultList;
    }

    public void removeClientById(UUID id) {
        clientRepository.deleteById(id);
    }
}
