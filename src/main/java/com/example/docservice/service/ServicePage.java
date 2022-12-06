package com.example.docservice.service;

import com.example.docservice.dto.DoctorsDto;
import com.example.docservice.dto.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.entity.Doctor;
import persistence.repository.DoctorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ServicePage {

    private final DoctorRepository doctorRepository;

    public ServicePage(DoctorRepository doctorsRepository) {
        this.doctorRepository = doctorsRepository;
    }


    public List<DoctorsDto> getAllDoctors() {
        List<Doctor> doctors = DoctorRepository.findAllDoctors();
        List<DoctorsDto> resultList = new ArrayList<>();
        for (Doctor doctor : doctors) {
            DoctorsDto doctorsDto = new DoctorsDto();
            doctorsDto.setId(doctor.getId().toString());
            doctorsDto.setEmail(doctor.getEmail());
            doctorsDto.setPassword(doctor.getPassword());
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
            doctorsDto.setTimeFrom(doctor.getTimeFrom());
            doctorsDto.setTimeTo(doctor.getTimeTo());
            resultList.add(doctorsDto);
        }

        return resultList;
    }

}