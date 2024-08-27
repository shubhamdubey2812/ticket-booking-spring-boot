package com.js.ticket_booking_spring_boot.serviceImpl;

import com.js.ticket_booking_spring_boot.entity.Customer;
import com.js.ticket_booking_spring_boot.repository.CustomerRepository;
import com.js.ticket_booking_spring_boot.response.ResponseStructure;
import com.js.ticket_booking_spring_boot.service.CustomerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ResponseStructure<Customer> responseStructure;

    @Autowired
    private HttpSession httpSession;
    @Override
    public ResponseStructure<Customer> saveCustomer(Customer customer) {
        Customer customer1=customerRepository.save(customer);
        if(customer1!=null){
            responseStructure.setStatusCode(HttpStatus.CREATED.value());
            responseStructure.setMessgae("cutomer registered");
            customer1.setPassword("**********************");
            responseStructure.setData(customer1);
            return responseStructure;
        }else {
            responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
            responseStructure.setMessgae("cutomer not registered...please check your code");
            customer1.setPassword("**********************");
            responseStructure.setData(customer1);
            return responseStructure;
        }
    }

    public ResponseStructure<Customer> loginCustomerWithEmailAndPasswordService(String email, String password) {
        Customer customer = customerRepository.findByEmail(email);
        if(customer!=null){

            if(customer.getPassword().equals(password)){

                httpSession.setAttribute("customerSession",email);
                httpSession.setMaxInactiveInterval(300);
                responseStructure.setStatusCode(HttpStatus.CONTINUE.value());
                responseStructure.setMessgae("login success go ahead");
                customer.setPassword("*******************");
                responseStructure.setData(customer);

                return  responseStructure;
            }else{
                responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
                responseStructure.setMessgae("login faild...because password is wrong");
                customer.setPassword("*******************");
                responseStructure.setData(customer);
                return  responseStructure;
            }

        }else {

            responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
            responseStructure.setMessgae("login faild...because email is wrong");
            responseStructure.setData(customer);
            return responseStructure;
        }
    }
}
