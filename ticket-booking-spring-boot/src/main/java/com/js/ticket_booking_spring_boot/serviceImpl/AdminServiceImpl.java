package com.js.ticket_booking_spring_boot.serviceImpl;

import com.js.ticket_booking_spring_boot.entity.Admin;
import com.js.ticket_booking_spring_boot.repository.AdminRepository;
import com.js.ticket_booking_spring_boot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Override
    public Admin findAdminByEmail(String email) {
        return adminRepository.findByEmail(email);
    }
}
