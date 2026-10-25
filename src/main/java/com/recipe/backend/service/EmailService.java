package com.recipe.backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired(required = false)
    private JavaMailSender mailSender;

    public void sendOTPEmail(String toEmail, String otp) {
        if (mailSender == null) {
            System.out.println("⚠️ MailSender not configured. OTP for " + toEmail + " is: " + otp);
            return;
        }
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Your OTP Code");
        message.setText("Your OTP code is: " + otp);
        mailSender.send(message);
    }

    public void sendOtpEmail(String email, String otp) {
        sendOTPEmail(email, otp);
    }
}

