package com.js.ticket_booking_spring_boot.repository;

import com.js.ticket_booking_spring_boot.entity.BookingTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingTicketRepository extends JpaRepository<BookingTicket,String> {
}
