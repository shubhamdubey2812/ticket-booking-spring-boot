package com.js.ticket_booking_spring_boot.service;

import java.io.File;

 public interface EmailService {
    //1.Send Email to Single Person
    void sendEmail(String to, String subject ,String message);

    //2.Send Email to Multiple Person
    void sendEmail(String []to, String subject, String message);

    //3.Send Email With Html
    void SendeEmailWthHtml(String to, String subject, String htmlContent);

    //4.Send Email With File
    void SendEmailWithFile(String to, String subject, String message, File file);

}
