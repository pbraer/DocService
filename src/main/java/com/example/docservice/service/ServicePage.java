package com.example.docservice.service;

import com.example.docservice.dto.DoctorsDto;
import com.example.docservice.persistence.entity.Doctor;
import com.example.docservice.persistence.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    public Doctor getDocById(String id) {
        Doctor doctor = null;
        List<Doctor> doctors = doctorRepository.findAllDoctors();
        for (Doctor doc : doctors) {
            if (doc.getId().equals(id)) {
                doctor = doc;
            }

        }

        return doctor;
    }

    public void createDoctor(DoctorsDto doctorsDto) {
        Doctor doctor = new Doctor();
        doctor.setId(String.valueOf(doctorRepository.findAllDoctors().size() + 1));
        doctor.setPass(doctor.getPass());
        doctor.setEmail(doctor.getEmail());
        doctor.setFirstname(doctor.getFirstname());
        doctor.setLastname(doctor.getLastname());
        doctor.setMiddlename(doctor.getMiddlename());
        doctor.setQualif(doctor.getQualif());
        doctor.setImage(doctor.getImage());
        doctor.setMonday(doctor.getMonday());
        doctor.setTuesday(doctor.getTuesday());
        doctor.setWednesday(doctor.getMonday());
        doctor.setThursday(doctor.getThursday());
        doctor.setFriday(doctor.getFriday());
        doctor.setSaturday(doctor.getSaturday());
        doctor.setSunday(doctor.getSunday());
        doctor.setTimefrom(doctor.getTimefrom());
        doctor.setTimeto(doctor.getTimeto());
        doctorRepository.save(doctor);

    }

    public void removeDoctorById(String id) {
        doctorRepository.deleteById(UUID.fromString(id));
    }

    public void updateDoctorInfo(DoctorsDto doctorsDto){
        removeDoctorById(doctorsDto.getId());
        createDoctor(doctorsDto);

    }


}