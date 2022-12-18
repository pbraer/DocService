package com.example.docservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;


@Service
public class UploadService {

    @Autowired
    private UploadService uploadService;

    void init() {

    }

    void store(MultipartFile file) {

    }

    Stream<Path> loadAll() {
        return null;
    }

    Path load(String fileName) {
        return null;
    }

    Resource loadAsResource(String fileName) {
        return null;
    }

    void deleteAll(){};

}
