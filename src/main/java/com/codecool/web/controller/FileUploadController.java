package com.codecool.web.controller;

import com.codecool.web.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
public class FileUploadController {

    @Autowired
    private StorageService storageService;


    @PostMapping("/file")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            storageService.store(file);
            return "OK";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to store file";
        }
    }

}
