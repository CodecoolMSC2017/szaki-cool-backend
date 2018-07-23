package com.codecool.web.component;

import com.codecool.web.model.Mail;
import com.codecool.web.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailComponent {

    @Autowired
    private EmailService emailService;


    public void sendTestMail() {
        Mail mail = new Mail();
        mail.setFrom("coolszaki@gmail.com");
        mail.setTo("coolszaki@gmail.com");
        mail.setSubject("Noreply - testing email sending service");
        mail.setContent("ok");

        emailService.sendSimpleMessage(mail);
    }

    @Async
    public void sendMail(String sendTo, String subject, String message){
        Mail mail = new Mail();
        mail.setFrom("coolszaki@gmail.com");
        mail.setTo(sendTo);
        mail.setSubject(subject);
        mail.setContent(message);

        emailService.sendSimpleMessage(mail);
    }

}
