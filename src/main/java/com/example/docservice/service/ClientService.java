package com.example.docservice.service;

import com.example.docservice.dto.ClientDto;
import com.example.docservice.persistence.entity.Client;
import com.example.docservice.persistence.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserService userService;


    public List<ClientDto> getAllRecords() {
        List<Client> clients = clientRepository.findAllClients();
        List<ClientDto> resultList = new ArrayList<>();
        for (Client client : clients) {
            ClientDto clientDto = new ClientDto();
            clientDto.setId(client.getId());
            clientDto.setUserid(client.getUserid());
            clientDto.setEmail(client.getEmail());
            clientDto.setPass(client.getPass());
            clientDto.setDoctor(client.getDoctor());
            clientDto.setQualif(client.getQualif());
            clientDto.setDateappoitm(client.getDateappoitm());
            clientDto.setTimeappoitm(client.getTimeappoitm());
            resultList.add(clientDto);
        }

        return resultList;
    }

    public List<Client> getRecordsById(String id) {
        List<Client> clients = clientRepository.findAllClients();
        List<Client> resultList = new ArrayList<>();
        for (Client client : clients) {
            if (client.getUserid().equals(id)){
                Client reg = new Client();
                reg.setId(client.getId());
                reg.setUserid(client.getUserid());
                reg.setEmail(userService.getEmailById(client.getUserid()));
                reg.setPass(userService.getPassById(client.getUserid()));
                reg.setDoctor(client.getDoctor());
                reg.setQualif(client.getQualif());
                reg.setDateappoitm(client.getDateappoitm());
                reg.setTimeappoitm(client.getTimeappoitm());
                resultList.add(reg);
            }
        }

        return resultList;
    }

    public void createRecord(ClientDto clientDto) {
        Client client = new Client();
        client.setId(String.valueOf(clientRepository.findAllClients().size() + 1));
        client.setUserid(clientDto.getUserid());
        client.setEmail(userService.getEmailById(client.getId()));
        client.setPass(userService.getPassById(client.getId()));
        client.setDoctor(clientDto.getDoctor());
        client.setQualif(clientDto.getQualif());
        client.setDateappoitm(clientDto.getDateappoitm());
        client.setTimeappoitm(clientDto.getTimeappoitm());
        clientRepository.save(client);

    }

    public List<ClientDto> getRecordsByEmail(String email) {
        List<Client> clients = clientRepository.findAllClients();
        List<ClientDto> resultList = new ArrayList<>();
        for (Client client : clients) {
            if (client.getEmail().equals(email)){
                ClientDto clientDto = new ClientDto();
                clientDto.setId(client.getId());
                clientDto.setUserid(client.getUserid());
                clientDto.setEmail(userService.getEmailById(client.getUserid()));
                clientDto.setPass(userService.getPassById(client.getUserid()));
                clientDto.setDoctor(client.getDoctor());
                clientDto.setQualif(client.getQualif());
                clientDto.setDateappoitm(client.getDateappoitm());
                clientDto.setTimeappoitm(client.getTimeappoitm());
                resultList.add(clientDto);
            }
        }

        return resultList;
    }


}
