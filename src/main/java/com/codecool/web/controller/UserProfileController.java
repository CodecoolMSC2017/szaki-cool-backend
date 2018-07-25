package com.codecool.web.controller;

import com.codecool.web.dto.ProfileDto;

import com.codecool.web.model.Profile;
import com.codecool.web.model.ProfileData;

import com.codecool.web.repository.ProfileRepo;
import com.codecool.web.service.ProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/profile")
public class UserProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/(id)")
    public Profile getProfileById(@PathVariable("id") long id) {
        return profileService.findByUserId(id);
    }




}
