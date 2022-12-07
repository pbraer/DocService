package com.example.docservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.docservice.dto.ClientDto;
import com.example.docservice.persistence.entity.Client;
import com.example.docservice.persistence.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ClientService {
    @Autowired
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository userRepository) {
        this.clientRepository = userRepository;
    }

    public List<ClientDto> createClient(ClientDto clientDto) {
        Client client = new Client();
        client.setId(UUID.randomUUID());
        client.setQualif(clientDto.getQualif());
        client.setFirstname(clientDto.getFirstname());
        client.setLastname(clientDto.getLastname());
        client.setMiddlename(clientDto.getMiddlename());
        client.setDate(clientDto.getDate());
        client.setTime(clientDto.getTime());

        clientRepository.save(client);

        return getAllClient();
    }

    public List<ClientDto> getAllClient() {
        List<Client> clients = clientRepository.findAllClients();
        List<ClientDto> resultList = new ArrayList<>();
        for (Client client : clients) {
            ClientDto clientDto = new ClientDto();
            clientDto.setId(Long.parseLong(client.getId().toString()));
            clientDto.setQualif(client.getQualif());
            clientDto.setFirstname(client.getFirstname());
            clientDto.setLastname(client.getLastname());
            clientDto.setMiddlename(client.getMiddlename());
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
