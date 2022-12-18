package com.example.docservice.service;

import com.example.docservice.dto.DoctorsDto;
import com.example.docservice.persistence.entity.Doctor;
import com.example.docservice.persistence.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicePage {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private UserService userService;

    public List<DoctorsDto> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAllDoctors();
        List<DoctorsDto> resultList = new ArrayList<>();
        for (Doctor doctor : doctors) {
            DoctorsDto doctorsDto = new DoctorsDto();
            doctorsDto.setId(doctor.getId().toString());
            doctorsDto.setUserid(doctor.getUserid());
            doctorsDto.setEmail(doctor.getEmail());
            doctorsDto.setPass(doctor.getPass());
            doctorsDto.setFirstname(doctor.getFirstname());
            doctorsDto.setLastname(doctor.getLastname());
            doctorsDto.setMiddlename(doctor.getMiddlename());
            doctorsDto.setQualif(doctor.getQualif());
            doctorsDto.setImage(doctor.getImage());
            doctorsDto.setMonday(doctor.getMonday());
            doctorsDto.setTuesday(doctor.getTuesday());
            doctorsDto.setWednesday(doctor.getWednesday());
            doctorsDto.setThursday(doctor.getThursday());
            doctorsDto.setFriday(doctor.getFriday());
            doctorsDto.setSaturday(doctor.getSaturday());
            doctorsDto.setSunday(doctor.getSunday());
            doctorsDto.setTimefrom(doctor.getTimefrom());
            doctorsDto.setTimeto(doctor.getTimeto());
            resultList.add(doctorsDto);
        }

        return resultList;
    }

    public Doctor findDoctorByUserId(String userid) {
        Doctor doctor = new Doctor();
        List<Doctor> doctors = doctorRepository.findAllDoctors();
        for (Doctor doc : doctors) {
            if (doc.getUserid().equals(userid)) {
                doctor = doc;
            }

        }

        return doctor;
    }

    public String findDoctorIdByUserId(String userid) {
        String id = null;
        List<Doctor> doctors = doctorRepository.findAllDoctors();
        for (Doctor doc : doctors) {
            if (doc.getUserid().equals(userid)) {
                id = doc.getId();
            }

        }

        return id;
    }

    public void createDoctor(DoctorsDto doctorsDto) {
        Doctor doctor = new Doctor();
        doctor.setId(doctorsDto.getId());
        doctor.setUserid(doctorsDto.getUserid());
        doctor.setPass(userService.getPassById(doctor.getId()));
        doctor.setEmail(userService.getEmailById(doctor.getId()));
        doctor.setFirstname(doctorsDto.getFirstname());
        doctor.setLastname(doctorsDto.getLastname());
        doctor.setMiddlename(doctorsDto.getMiddlename());
        doctor.setQualif(doctorsDto.getQualif());
        doctor.setImage(doctorsDto.getImage());
        doctor.setMonday(doctorsDto.getMonday());
        doctor.setTuesday(doctorsDto.getTuesday());
        doctor.setWednesday(doctorsDto.getMonday());
        doctor.setThursday(doctorsDto.getThursday());
        doctor.setFriday(doctorsDto.getFriday());
        doctor.setSaturday(doctorsDto.getSaturday());
        doctor.setSunday(doctorsDto.getSunday());
        doctor.setTimefrom(doctorsDto.getTimefrom());
        doctor.setTimeto(doctorsDto.getTimeto());
        doctorRepository.save(doctor);

    }

    public void updateDoctorInfo(DoctorsDto doctorsDto){
        doctorsDto.setId(findDoctorIdByUserId(doctorsDto.getUserid()));
        List<DoctorsDto> docList = getAllDoctors();
        docList.removeIf(doc -> (doc.getId() == doctorsDto.getId()));
        doctorRepository.deleteAll();
        for (DoctorsDto doc : docList) {
            createDoctor(doc);

        }

        createDoctor(doctorsDto);

    }


}