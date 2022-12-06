package com.example.docservice.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.docservice.dto.Login;
import com.example.docservice.persistence.entity.Doctor;
import com.example.docservice.persistence.repository.DoctorRepository;



@Service
public class DocServicePage implements UserDetailsService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private DoctorRepository docRepository;
    @Autowired
    private BCryptPasswordEncoder CryptPasswordEncoder;





//    private final DocRepository accountRepository;
//
//    public DocServicePage(DocRepository accountRepository) {
//        this.accountRepository = accountRepository;
//    }

    public static void createUser(Login login) {
        Doctor profileDoc = new Doctor();
        profileDoc.setEmail(login.getLogin());
        profileDoc.setPassword(login.getPass());

//        accountRepository.save(profileDoc);
//
//        List<ProfileDoc> lisr = accountRepository.findAllDoctors();
        System.out.println("");
    }
    public static void (String email) //throws UsernameNotFoundException
    {
        Doctor doc = DoctorRepository.findByEmail(email);

        if (doc == null) {
            //throw new UsernameNotFoundException("User not found");
            return null;
        }

        return doc;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}

