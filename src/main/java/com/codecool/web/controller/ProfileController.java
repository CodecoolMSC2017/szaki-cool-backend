package com.codecool.web.controller;

import com.codecool.web.model.Profile;
import com.codecool.web.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProfileController {

    @Autowired
    ProfileService profileService;


    public Profile something(){
        System.out.println("ok");
        return null;
    }
}
