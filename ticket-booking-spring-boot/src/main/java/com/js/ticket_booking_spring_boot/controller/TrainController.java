package com.js.ticket_booking_spring_boot.controller;

import com.js.ticket_booking_spring_boot.entity.Train;
import com.js.ticket_booking_spring_boot.response.ResponseStructure;
import com.js.ticket_booking_spring_boot.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping("/api/train")
public class TrainController {
    @Autowired
    private TrainService trainService;

    @PostMapping("/save")
    public ResponseStructure<Train> saveTrain(@RequestBody Train train){

        return trainService.saveTrain(train);
    }
    @GetMapping("/fetchTrain/{trainNumber}")
    public ResponseStructure<Train> searchTrainByTrainNumber(@PathVariable long trainNumber){
        return trainService.searchTrainByTrainNumber(trainNumber);
    }
    @GetMapping("/fetchTrain/{source}/{destination}")
    public ResponseStructure<List<Train>> searchTrainBySourceAndDestination(@PathVariable String source,
                                                                            @PathVariable String destination){
        return trainService.searchTrainBySourceAndDestination(source,destination);
    }

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @GetMapping("/fetchTrainBySourceDestinationAndDate")
    public ResponseEntity<?> fetchTrainBySourceDestinationAndDate(@RequestParam String source,
                                                                  @RequestParam String destination,
                                                                  @RequestParam String date) {
        try {
            LocalDate availableDate = LocalDate.parse(date, formatter);
            List<Train> trains = trainService.findBySourceAndDestinationAndAvailableDate(source, destination, availableDate);
            return new ResponseEntity<>(trains, HttpStatus.OK);
        } catch (DateTimeParseException e) {
            return new ResponseEntity<>("Invalid date format. Please use dd/MM/yyyy.", HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An unexpected error occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
