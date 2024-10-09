package com.js.ticket_booking_spring_boot.serviceImpl;

import com.js.ticket_booking_spring_boot.entity.BookingTicket;
import com.js.ticket_booking_spring_boot.entity.Customer;
import com.js.ticket_booking_spring_boot.entity.Train;
import com.js.ticket_booking_spring_boot.repository.BookingTicketRepository;
import com.js.ticket_booking_spring_boot.repository.CustomerRepository;
import com.js.ticket_booking_spring_boot.repository.TrainRepository;
import com.js.ticket_booking_spring_boot.service.BookingTicketService;
import com.js.ticket_booking_spring_boot.utils.GeneratePnr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingTicketServiceImpl implements BookingTicketService {
    @Autowired
    private BookingTicketRepository bookingTicketRepository;
    @Autowired
    private TrainRepository trainRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public BookingTicket saveBookingTicket(BookingTicket bookingTicket,String cutomerEmail,long trainNumber) {
        Customer customerEmail=customerRepository.findByEmail(cutomerEmail);
        Train trainNum=trainRepository.findByTrainNumber(trainNumber);
        if(trainNum!=null && customerEmail!=null){
            bookingTicket.setCustomer(customerEmail);
            bookingTicket.setTrain(trainNum);
            bookingTicket.setPnr(GeneratePnr.generatePnr());
            return bookingTicketRepository.save(bookingTicket);
        }else {
            throw new RuntimeException("Tain is not available or customer Email");
        }


    }
}
