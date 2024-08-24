package com.js.ticket_booking_spring_boot.service;

import com.js.ticket_booking_spring_boot.entity.Admin;
import com.js.ticket_booking_spring_boot.response.ResponseStructure;

public interface AdminService {
    public Admin findAdminByEmail(String email);
    ResponseStructure<Admin> loginAdminWithEmailAndPasswordService(String email,String password);

    ResponseStructure<Admin> LogoutAdminService();
}
