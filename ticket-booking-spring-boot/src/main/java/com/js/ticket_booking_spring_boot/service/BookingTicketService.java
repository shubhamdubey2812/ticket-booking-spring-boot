package com.js.ticket_booking_spring_boot.service;

import com.js.ticket_booking_spring_boot.entity.BookingTicket;

public interface BookingTicketService {
    public BookingTicket saveBookingTicket(BookingTicket bookingTicket,String cutomerEmail,long trainNumber);
}
