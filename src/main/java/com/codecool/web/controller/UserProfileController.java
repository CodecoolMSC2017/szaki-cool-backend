package com.codecool.web.controller;

import com.codecool.web.controller.exceptions.FailedToParseIdFromProfilePostRequestException;
import com.codecool.web.model.Profile;
import com.codecool.web.service.ProfileService;
import com.codecool.web.service.exceptions.NoProfileRegisteredWithThisUserIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.sql.DataSource;
import java.util.Map;

@RestController
@RequestMapping("/profile")
public class UserProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private DataSource dataSource;

    @GetMapping("/{id}")
    public Profile getProfileById(@PathVariable("id") Integer id) {
        return profileService.findByUserId(id);
    }

    @PostMapping("/update")
    public void updateProfile(@RequestBody Map<String, String> map) throws NoProfileRegisteredWithThisUserIdException {
        Integer userId = Integer.parseInt(map.get("userId"));
        profileService.updateProfileByUserId(userId, map);
    }
}
