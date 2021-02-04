package com.FivePoints.Spring.controllers;

import com.FivePoints.Spring.models.Post;
import com.FivePoints.Spring.models.User;
import com.FivePoints.Spring.payload.responses.MessageResponse;
import com.FivePoints.Spring.services.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
public class MailSenderController {

    @Autowired
    private MailSenderService mailSenderService;

    @PostMapping("/addMail")
    ResponseEntity<MessageResponse> newPost(@RequestBody User user) {
        System.out.println("Sending Email...");

        try {
            mailSenderService.sendEmail();
            mailSenderService.sendEmailWithAttachment(user);

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String message ="mail sent ";

        return ResponseEntity.ok().body(new MessageResponse(message));
    }
}
