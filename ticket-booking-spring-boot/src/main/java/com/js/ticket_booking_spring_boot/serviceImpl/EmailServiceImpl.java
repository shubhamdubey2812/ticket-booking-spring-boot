package com.js.ticket_booking_spring_boot.serviceImpl;

import com.js.ticket_booking_spring_boot.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender mailSender;
    @Override
    public void sendEmail(String to, String subject, String message) {
        SimpleMailMessage simple=new SimpleMailMessage();
        simple.setTo(to);
        simple.setSubject(subject);
        simple.setFrom("btech2812@gmail.com");
        simple.setText(message);
        mailSender.send(simple);

    }

    @Override
    public void sendEmail(String[] to, String subject, String message) {
        SimpleMailMessage simple=new SimpleMailMessage();
        simple.setTo(to);
        simple.setSubject(subject);
        simple.setFrom("btech2812@gmail.com");
        simple.setText(message);
        mailSender.send(simple);

    }

    @Override
    public void SendeEmailWthHtml(String to, String subject, String htmlContent){
        MimeMessage message=mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper=new MimeMessageHelper(message,true,"UTF-8");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setFrom("btech2812@gmail.com");
            helper.setText(htmlContent,true);

            mailSender.send(message);

        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void SendEmailWithFile(String to, String subject, String message, File file) {
        MimeMessage msg=mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper=new MimeMessageHelper(msg,true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setFrom("btech2812@gmail.com");
            helper.setText(message);
            FileSystemResource fsr=new FileSystemResource(file);
            helper.addAttachment(file.getName(),fsr);

            mailSender.send(msg);
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


}
