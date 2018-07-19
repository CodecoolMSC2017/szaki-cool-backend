package com.codecool.web.controller;

import com.codecool.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/account")
public class ActivationVerificationController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/test", params = {"key"}, method = RequestMethod.GET)
    public @ResponseBody String activateByEmail(@RequestParam("key") String key){
        userService.activateUser(key);
        return "account activated with key= " + key;
    }

    @PostMapping("*")
    public String activateAccount(@RequestBody Map<String, String> map) {
        String activationCode = map.get("activationCode");
        userService.activateUser(activationCode);
        return "account activated";
    }
}
