package com.js.ticket_booking_spring_boot.controller;

import com.js.ticket_booking_spring_boot.entity.Train;
import com.js.ticket_booking_spring_boot.response.ResponseStructure;
import com.js.ticket_booking_spring_boot.service.TrainService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/train")
public class TrainController {
    @Autowired
    private TrainService trainService;

    @PostMapping("/save")
    public ResponseStructure<Train> saveTrain(@RequestBody Train train){
        return trainService.saveTrain(train);
    }
}
