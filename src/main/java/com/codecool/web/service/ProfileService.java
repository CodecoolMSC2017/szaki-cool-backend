package com.codecool.web.service;

import com.codecool.web.model.Profile;
import com.codecool.web.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public Iterable<Profile> getAll() {
        return profileRepository.findAll();
    }

    public Optional<Profile> get(long user_id) {
        return profileRepository.findByUserId(user_id);
    }

    public void delete(Integer user_id) {
        profileRepository.deleteById(user_id);
    }

}
