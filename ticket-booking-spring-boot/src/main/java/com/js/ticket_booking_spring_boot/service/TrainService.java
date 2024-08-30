package com.js.ticket_booking_spring_boot.service;

import com.js.ticket_booking_spring_boot.entity.Train;
import com.js.ticket_booking_spring_boot.response.ResponseStructure;

import java.time.LocalDate;
import java.util.List;

public interface TrainService {
    public ResponseStructure<Train> saveTrain(Train train);
    ResponseStructure<Train> searchTrainByTrainNumber(long trainNumber);
    ResponseStructure<List<Train>> searchTrainBySourceAndDestination(String source, String destination);

    List<Train> findBySourceAndDestinationAndAvailableDate(String source, String destination, LocalDate date);

}
