package com.js.ticket_booking_spring_boot.repository;

import com.js.ticket_booking_spring_boot.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train,Long> {
}
