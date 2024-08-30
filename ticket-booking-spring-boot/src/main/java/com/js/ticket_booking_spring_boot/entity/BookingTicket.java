package com.js.ticket_booking_spring_boot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingTicket {
    @Id
    private long pnr;
    private String passengerName;
    private int passengerAge;
    private String gender;
    private LocalDate journeyDate;

    @ManyToOne
    private Customer customer;

    @OneToOne
    private Train train;
}
