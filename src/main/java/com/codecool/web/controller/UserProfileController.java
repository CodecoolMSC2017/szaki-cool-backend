package com.codecool.web.controller;

import com.codecool.web.controller.exceptions.FailedToParseIdFromProfilePostRequestException;
import com.codecool.web.model.Profile;
import com.codecool.web.service.ProfileService;
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

    @GetMapping("/(id)")
    public Profile getProfileById(@PathVariable("id") long id) {
        return profileService.findByUserId(id);
    }

    @PostMapping("/update")
    public String updateProfile(@RequestBody Map<String, String> map) throws FailedToParseIdFromProfilePostRequestException {
        try {
            long userId = Long.parseLong(map.get("userId"));
            profileService.updateProfileByUserId(userId, map);
        }
        catch (Exception e) {
            throw new FailedToParseIdFromProfilePostRequestException();
        }
        return "update successful";
    }




}
