package com.js.ticket_booking_spring_boot.repository;

import com.js.ticket_booking_spring_boot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByEmail(String email);
}
