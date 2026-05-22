package com.gemini.email.generator.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gemini.email.generator.DTO.EmailRequest;
import com.gemini.email.generator.service.EmailService;
import com.gemini.email.generator.DTO.EmailResponse;

@RequestMapping("/api/email")
@RestController
@CrossOrigin(origins = "https://mail.google.com")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/generate")
    public String generateEmailResponse(@RequestBody EmailRequest request) {
        String response = emailService.generateEmailReply(request);
        return response;
    }
    
}
