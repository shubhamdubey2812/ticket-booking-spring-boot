package com.js.ticket_booking_spring_boot.controller;

import com.js.ticket_booking_spring_boot.entity.Admin;
import com.js.ticket_booking_spring_boot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
   @Autowired
    private AdminService adminService;
    @GetMapping("/get/{email}")
    public Admin getAdminDate(@PathVariable String email){
     return adminService.findAdminByEmail(email) ;
    }

}

