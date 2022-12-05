package com.example.docservice.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.example.docservice.dto.Login;
import com.example.docservice.entity.ProfileDoc;
import com.example.docservice.repository.DocRepository;



@Service
public class DocServicePage implements UserDetailsService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private DocRepository docRepository;
    @Autowired
    private BCryptPasswordEncoder CryptPasswordEncoder;





//    private final DocRepository accountRepository;
//
//    public DocServicePage(DocRepository accountRepository) {
//        this.accountRepository = accountRepository;
//    }

    public static void createUser(Login login) {
        ProfileDoc profileDoc = new ProfileDoc();
        profileDoc.setEmail(login.getLogin());
        profileDoc.setPassword(login.getPass());

//        accountRepository.save(profileDoc);
//
//        List<ProfileDoc> lisr = accountRepository.findAllDoctors();
        System.out.println("");
    }
    public static void (String email) //throws UsernameNotFoundException
    {
        ProfileDoc doc = DocRepository.findByEmail(email);

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

