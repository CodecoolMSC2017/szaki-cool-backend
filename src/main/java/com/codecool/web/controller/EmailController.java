package com.codecool.web.controller;

import com.codecool.web.model.Mail;
import com.codecool.web.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping(path = "/email" , method=RequestMethod.GET)
    public void makeMail() throws Exception {
        Mail mail = new Mail();
        mail.setFrom("coolszaki@gmail.com");
        mail.setTo("sauriaster@gmail.com");
        mail.setSubject("Noreply - testing email sending");
        mail.setContent("This is just a test.");

        emailService.sendSimpleMessage(mail);
    }

}
