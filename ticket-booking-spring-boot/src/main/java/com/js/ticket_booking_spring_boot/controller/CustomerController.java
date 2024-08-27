package com.js.ticket_booking_spring_boot.controller;

import com.js.ticket_booking_spring_boot.entity.Customer;
import com.js.ticket_booking_spring_boot.response.ResponseStructure;
import com.js.ticket_booking_spring_boot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/saveCustomer")
    public ResponseStructure<Customer> saveCustomer(@RequestBody Customer customer){
     return customerService.saveCustomer(customer);
    }

    @GetMapping("/login/{email}/{password}")
    public ResponseStructure<Customer> loginCustomerWithEmailAndPasswordService(@PathVariable String email, @PathVariable String password) {
        return customerService.loginCustomerWithEmailAndPasswordService(email,password);
    }

}
