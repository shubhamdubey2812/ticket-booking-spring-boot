package com.js.ticket_booking_spring_boot.service;

import com.js.ticket_booking_spring_boot.entity.Customer;
import com.js.ticket_booking_spring_boot.response.ResponseStructure;

public interface CustomerService {
    ResponseStructure<Customer> saveCustomer(Customer customer);
    public ResponseStructure<Customer> loginCustomerWithEmailAndPasswordService(String email, String password);
}
