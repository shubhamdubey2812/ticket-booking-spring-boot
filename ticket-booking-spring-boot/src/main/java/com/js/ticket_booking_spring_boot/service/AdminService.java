package com.js.ticket_booking_spring_boot.service;

import com.js.ticket_booking_spring_boot.entity.Admin;

public interface AdminService {
    public Admin findAdminByEmail(String email);
}
