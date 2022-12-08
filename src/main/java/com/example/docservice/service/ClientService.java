package com.example.docservice.service;

import com.example.docservice.dto.Login;
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
    private ClientRepository clientRepository;


    public void createClient(ClientDto clientDto) {
        Client client = new Client();
        client.setId(String.valueOf(clientRepository.findAllClients().size() + 1));
        client.setEmail(clientDto.getEmail());
        client.setPass(clientDto.getPass());
        client.setQualif(clientDto.getQualif());
        client.setFirstname(clientDto.getFirstname());
        client.setLastname(clientDto.getLastname());
        client.setMiddlename(clientDto.getMiddlename());
        client.setDateAppoitm(clientDto.getDateAppoitm());
        client.setTimeAppoitm(clientDto.getTimeAppoitm());

        clientRepository.save(client);
    }


    public void updateUser(Login login) {
        Client client = new Client();
        client.setId(String.valueOf(clientRepository.findAllClients().size() + 1));
        client.setEmail(login.getEmail());
        client.setPass(login.getPass());
        client.setQualif(null);
        client.setFirstname(null);
        client.setLastname(null);
        client.setMiddlename(null);
        client.setDateAppoitm(null);
        client.setTimeAppoitm(null);
        clientRepository.save(client);
    }



    public List<ClientDto> getAllClient() {
        List<Client> clients = clientRepository.findAllClients();
        List<ClientDto> resultList = new ArrayList<>();
        for (Client client : clients) {
            ClientDto clientDto = new ClientDto();
            clientDto.setId(client.getId().toString());
            clientDto.setQualif(client.getQualif().toString());
            clientDto.setFirstname(client.getFirstname().toString());
            clientDto.setLastname(client.getLastname().toString());
            clientDto.setMiddlename(client.getMiddlename().toString());
            clientDto.setDateAppoitm(client.getDateAppoitm().toString());
            clientDto.setTimeAppoitm(client.getTimeAppoitm().toString());
            resultList.add(clientDto);
        }

        return resultList;
    }

    public void removeClientById(UUID id) {
        clientRepository.deleteById(id);
    }
}
