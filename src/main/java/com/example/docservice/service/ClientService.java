package com.example.docservice.service;

import com.example.docservice.dto.ClientDto;
import com.example.docservice.persistence.entity.Client;
import com.example.docservice.persistence.entity.ClientFiles;
import com.example.docservice.persistence.entity.Regs;
import com.example.docservice.persistence.repository.ClientRepository;
import com.example.docservice.persistence.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ServicePage servicePage;


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
            clientDto.setDoctorid(client.getDoctorid());
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
                reg.setDoctorid(client.getDoctorid());
                reg.setQualif(client.getQualif());
                reg.setDateappoitm(client.getDateappoitm());
                reg.setTimeappoitm(client.getTimeappoitm());
                resultList.add(reg);
            }
        }

        return resultList;
    }

    public List<Client> getRecordsByDocId(String id) {
        List<Client> clients = clientRepository.findAllClients();
        List<Client> resultList = new ArrayList<>();
        for (Client client : clients) {
            if (client.getDoctorid().equals(id)){
                Client reg = new Client();
                reg.setId(client.getId());
                reg.setUserid(client.getUserid());
                reg.setEmail(userService.getEmailById(client.getUserid()));
                reg.setPass(userService.getPassById(client.getUserid()));
                reg.setDoctor(client.getDoctor());
                reg.setDoctorid(client.getDoctorid());
                reg.setQualif(client.getQualif());
                reg.setDateappoitm(client.getDateappoitm());
                reg.setTimeappoitm(client.getTimeappoitm());
                if (resultList.contains(reg) == false){
                    resultList.add(reg);
                }

            }
        }

        return resultList;
    }

    public String getRecordsTimeByDate(String id, String Date) {
        List<Client> clients = clientRepository.findAllClients();
        String result = "";
        for (Client client : clients) {
            if (client.getDateappoitm().equals(Date) && client.getUserid().equals(id)){
                result = client.getTimeappoitm();
            }
        }

        return result;
    }

    public List<Client> getClientRecordsByDoc(String docid, String clientid) {
        List<Client> clients = clientRepository.findAllClients();
        List<Client> resultList = new ArrayList<>();
        for (Client client : clients) {
            if (client.getUserid().equals(clientid) && client.getDoctorid().equals(docid)){
                Client reg = new Client();
                reg.setId(client.getId());
                reg.setUserid(client.getUserid());
                reg.setEmail(userService.getEmailById(client.getUserid()));
                reg.setPass(userService.getPassById(client.getUserid()));
                reg.setDoctor(client.getDoctor());
                reg.setDoctorid(client.getDoctorid());
                reg.setQualif(client.getQualif());
                reg.setDateappoitm(client.getDateappoitm());
                reg.setTimeappoitm(client.getTimeappoitm());
                resultList.add(reg);
            }
        }

        return resultList;
    }

    public List<Regs> getNearestDatas(String docid) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String today = LocalDate.now().format(formatter); // date -> string
        LocalDate dateToday = LocalDate.parse(today, formatter); // string -> date
        List<LocalDate> dates = new ArrayList<>();
        String lastdate = "-";
        String futuredate = "-";
        String lasttime = "";
        String futuretime = "";
        List<Regs> resultList = new ArrayList<>();
        for (Client person : getRecordsByDocId(docid)) {
            for (Client client : getRecordsById(person.getUserid())) {
                LocalDate next = LocalDate.parse(client.getDateappoitm(), formatter);
                dates.add(next);
            }
            if (dates.size() > 0) {

                for (int i = 1; i < 14; i++) {
                    LocalDate step = dateToday.minusDays(i);
                    if (dates.contains(step)) {
                        lastdate = step.format(formatter);
                        lasttime = getRecordsTimeByDate(person.getUserid(), lastdate);
                        break;
                    }

                }

            }else {
                lastdate = "";
            }

            if (dates.size() > 0) {
                for (int i = 1; i < 14; i++) {
                    LocalDate step = dateToday.plusDays(i);
                    if (dates.contains(step)) {
                        futuredate = step.format(formatter);
                        futuretime = getRecordsTimeByDate(person.getUserid(), futuredate);
                        break;
                    }

                }

            }else {
                futuredate = "";
            }
            Regs pers = new Regs();
            pers.setUserid(person.getUserid());
            pers.setEmail(person.getEmail());
            pers.setFuturedate(futuredate);
            pers.setLastdate(lastdate);
            pers.setFuturetime(futuretime);
            pers.setLasttime(lasttime);
            if (resultList.contains(pers) == false){
                resultList.add(pers);
            }

        }


        return resultList;
    }


    public void createRecord(ClientDto clientDto) {
        Client client = new Client();
        client.setId(String.valueOf(clientRepository.findAllClients().size() + 1));
        client.setUserid(clientDto.getUserid());
        client.setEmail(userService.getEmailById(client.getUserid()));
        client.setPass(userService.getPassById(client.getId()));
        client.setDoctorid(clientDto.getDoctorid());
        client.setDoctor(servicePage.getFioById(client.getDoctorid()));
        client.setQualif(clientDto.getQualif());
        client.setDateappoitm(clientDto.getDateappoitm());
        client.setTimeappoitm(clientDto.getTimeappoitm());
        clientRepository.save(client);

    }

    public void addDocument(String clientid, String docid, String document) {
        ClientFiles client = new ClientFiles();
        client.setId(String.valueOf(fileRepository.findAllFiles().size() + 1));
        client.setClientid(clientid);
        client.setDocid(docid);
        System.out.println(document);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String today = LocalDate.now().format(formatter); // date -> string
        client.setDatemeet(today);

        client.setDoctor(servicePage.findDoctorByUserId(docid).getLastname() +
                " " + servicePage.findDoctorByUserId(docid).getFirstname().charAt(0)
                + "." + servicePage.findDoctorByUserId(docid).getMiddlename().charAt(0) + ".");
        client.setFilename(document);
        fileRepository.save(client);

    }

    public List<ClientFiles> findDocsByUserId(String docid) {
        ClientFiles file = new ClientFiles();
        List<ClientFiles> documents = new ArrayList<>();
        List<ClientFiles> files = fileRepository.findAllFiles();
        for (ClientFiles doc : files) {
            if (doc.getDocid().equals(docid)) {
                documents.add(doc);
            }
        }

        return documents;
    }

    public List<ClientFiles> findDocsByClientId(String id) {
        ClientFiles file = new ClientFiles();
        List<ClientFiles> documents = new ArrayList<>();
        List<ClientFiles> files = fileRepository.findAllFiles();
        for (ClientFiles doc : files) {
            if (doc.getClientid().equals(id)) {
                documents.add(doc);
            }
        }

        return documents;
    }




    public void doc_records(ClientDto clientDto) {
        Client client = new Client();
        client.setId(String.valueOf(clientRepository.findAllClients().size() + 1));
        client.setUserid(clientDto.getUserid());
        client.setEmail(userService.getEmailById(client.getId()));
        client.setPass(userService.getPassById(client.getId()));
        client.setDoctor(clientDto.getDoctor());
        client.setDoctorid(clientDto.getDoctorid());
        client.setQualif(clientDto.getQualif());
        client.setDateappoitm(clientDto.getDateappoitm());
        client.setTimeappoitm(clientDto.getTimeappoitm());
        clientRepository.save(client);

    }


}
