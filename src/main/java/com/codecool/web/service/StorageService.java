package com.codecool.web.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

@Service
public class StorageService {


    public void store(MultipartFile file) throws IOException {
        URL url = StorageService.class.getResource("/pics");
        String path = url.getPath();
        File convFile = new File(path + "/" + file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
    }
}
