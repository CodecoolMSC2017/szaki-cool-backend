package com.codecool.web.service;

import com.codecool.web.model.Profile;
import com.codecool.web.model.User;
import com.codecool.web.repository.ProfileRepository;
import com.codecool.web.repository.UserRepository;
import com.codecool.web.service.exceptions.NoProfileRegisteredWithThisUserIdException;
import de.perschon.resultflow.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserRepository userRepository;

    public Iterable<Profile> getAll() {
        return profileRepository.findAll();
    }

    public void delete(Integer user_id) {
        profileRepository.deleteById(user_id);
    }

    public Profile findByUserId(Integer id) {
        return profileRepository.findByUserId(id).get();
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
        currentProfile.setDescription(map.get("description"));

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

    public Result<String, String> getProfilePictureName(Integer id) {
        Optional<Profile> profile = profileRepository.findByUserId(id);
        if(profile.isPresent()){
            return Result.ok(profile.get().getPicture());
        }
        else {
            return Result.err("No profile found by this id");
        }
    }
}
