package com.js.ticket_booking_spring_boot.repository;

import com.js.ticket_booking_spring_boot.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
    Admin findByEmail(String email);
}
