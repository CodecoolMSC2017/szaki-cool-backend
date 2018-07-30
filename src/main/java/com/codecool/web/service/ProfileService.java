package com.codecool.web.service;

import com.codecool.web.model.Profile;
import com.codecool.web.repository.ProfileRepository;
import com.codecool.web.service.exceptions.NoProfileRegisteredWithThisUserIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public Iterable<Profile> getAll() {
        return profileRepository.findAll();
    }

    public Optional<Profile> getOptional(Integer user_id) {
        return profileRepository.findByUserId(user_id);
    }

    public void delete(Integer user_id) {
        profileRepository.deleteById(user_id);
    }

    public Profile findByUserId(Integer id) {
        Optional<Profile> optional = getOptional(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }


    private List<Profile> getAllRegisteredProfileList(){
        Iterable<Profile> iterable = getAll();
        List<Profile> target = new ArrayList<>();
        iterable.forEach(target::add);
        return target;
    }

    private Profile makeProfileFromMap(Map<String, String> map, Profile currentProfile){
        currentProfile.setFirstName(map.get("firstName"));
        currentProfile.setLastName(map.get("lastName"));
        currentProfile.setPhone(map.get("phone"));
        currentProfile.setAddress(map.get("address"));
        currentProfile.setPicture(map.get("picture"));
        currentProfile.setPicture(map.get("description"));

        return currentProfile;
    }

    public void updateProfileByUserId(Integer userId, Map<String, String> map) throws NoProfileRegisteredWithThisUserIdException {
        try {
            Profile profile = profileRepository.findByUserId(userId).get();
            profile = makeProfileFromMap(map, profile);
            profileRepository.save(profile);
        }
        catch (NoSuchElementException ns){
            throw new NoProfileRegisteredWithThisUserIdException();
        }
    }



}
