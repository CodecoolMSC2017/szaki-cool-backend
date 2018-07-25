package com.codecool.web.service;

import com.codecool.web.model.Profile;
import com.codecool.web.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public Iterable<Profile> getAll() {
        return profileRepository.findAll();
    }

    public Optional<Profile> getOptional(long user_id) {
        return profileRepository.findByUserId(user_id);
    }

    public void delete(Integer user_id) {
        profileRepository.deleteById(user_id);
    }

    public Profile findByUserId(long id) {
        Optional<Profile> optional = getOptional(id);
        Profile profile = optional.get();
        return profile;
    }


    private List<Profile> getAllRegisteredProfileList(){
        Iterable<Profile> iterable = getAll();
        List<Profile> target = new ArrayList<>();
        iterable.forEach(target::add);
        return target;
    }



}
