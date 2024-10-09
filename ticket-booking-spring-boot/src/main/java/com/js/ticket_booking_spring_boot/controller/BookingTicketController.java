package com.js.ticket_booking_spring_boot.controller;

import com.js.ticket_booking_spring_boot.entity.BookingTicket;
import com.js.ticket_booking_spring_boot.service.BookingTicketService;
import com.js.ticket_booking_spring_boot.service.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book/ticket")
public class BookingTicketController {
    @Autowired
    private BookingTicketService bookingTicketService;
    @Autowired
    private EmailService emailService;


   
    @PostMapping("/save/bookticket/{customerEmail}/{trainNumber}")
    public ResponseEntity<BookingTicket> saveBookingTicket(@RequestBody BookingTicket bookingTicket,
                                                           @PathVariable String customerEmail,
                                                           @PathVariable long trainNumber){
       BookingTicket book= bookingTicketService.saveBookingTicket(bookingTicket,customerEmail,trainNumber);


 emailService.sendEmail(
                customerEmail,
                "Ticket Booking Confirmation", // Subject of the email
                "Dear " + bookingTicket.getPassengerName() + ",\n\n" + // Salutation with Passenger Name
                        "Your ticket has been successfully booked.\n\n" +
                        "Booking Details:\n" +
                        "-----------------------\n" +
                        "Train Number    : " + trainNumber + "\n" +
                        "PNR Number      : " + bookingTicket.getPnr() + "\n" +
                        "Passenger Name  : " + bookingTicket.getPassengerName() + "\n" +
                        "Passenger Age   : " + bookingTicket.getPassengerAge() +"\n" +
                        "Passenger Gender: " + bookingTicket.getGender() +"\n" +
                        "Journy Date     : " + bookingTicket.getJourneyDate() +"\n" +
                        "-----------------------\n\n" +
                        "Thank you for choosing our service. We wish you a pleasant journey!\n\n" +
                        "Best regards,\n" +
                        "Shubham Kumar Dubey"
        );


        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
