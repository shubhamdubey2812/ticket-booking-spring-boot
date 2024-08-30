package com.js.ticket_booking_spring_boot.repository;

import com.js.ticket_booking_spring_boot.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TrainRepository extends JpaRepository<Train,Long> {

    public Train findByTrainNumber(long trainNumber);
    public List<Train> findBySourceAndDestination(String source, String destination);
    public List<Train> findBySourceAndDestinationAndAvailableDate(String source, String destination, LocalDate date);

}
