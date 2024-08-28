package com.js.ticket_booking_spring_boot.service;

import com.js.ticket_booking_spring_boot.entity.Train;
import com.js.ticket_booking_spring_boot.response.ResponseStructure;

public interface TrainService {
    public ResponseStructure<Train> saveTrain(Train train);
}
