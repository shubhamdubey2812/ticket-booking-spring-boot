package com.js.ticket_booking_spring_boot.serviceImpl;

import com.js.ticket_booking_spring_boot.entity.Train;
import com.js.ticket_booking_spring_boot.exception.TrainNotFoundException;
import com.js.ticket_booking_spring_boot.repository.TrainRepository;
import com.js.ticket_booking_spring_boot.response.ResponseStructure;
import com.js.ticket_booking_spring_boot.service.TrainService;
import com.js.ticket_booking_spring_boot.utils.CalculationTrainDuration;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {
    @Autowired
    private TrainRepository trainRepository;
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private ResponseStructure<Train> responseStructure;
    @Autowired
    private ResponseStructure<List<Train>> responseStructureList;
    @Override
    public ResponseStructure<Train> saveTrain(Train train) {
        if(httpSession.getAttribute("adminSession")!=null){

            train.setDuration(CalculationTrainDuration.calculateDuration(train.getDepartureTime(),train.getArrivalTime()));

            Train train1=trainRepository.save(train);
            if(train1!=null){
                responseStructure.setStatusCode(HttpStatus.CREATED.value());
                responseStructure.setMessgae("Train Registerd");
                responseStructure.setData(train1);
                return  responseStructure;
            }else {
                responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
                responseStructure.setMessgae("Train not registered ");
                responseStructure.setData(null);
                return responseStructure;
            }
        }
        else {
            responseStructure.setStatusCode(HttpStatus.UNAUTHORIZED.value());
            responseStructure.setMessgae("Not Registered");
            responseStructure.setData(null);
            return responseStructure;
        }

    }

    @Override
    public ResponseStructure<Train> searchTrainByTrainNumber(long trainNumber) {
        Train train1=trainRepository.findByTrainNumber(trainNumber);
        if(train1!=null){
            responseStructure.setStatusCode(HttpStatus.FOUND.value());
            responseStructure.setMessgae("Train is Available with given Train Number");
            responseStructure.setData(train1);
            return responseStructure;
        }else {
            responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
            responseStructure.setMessgae("Train is Not Available with given Train NUmber");
            responseStructure.setData(null);
            return responseStructure;
        }

    }

    @Override
    public ResponseStructure<List<Train>> searchTrainBySourceAndDestination(String source, String destination) {
       List<Train> trains= trainRepository.findBySourceAndDestination(source,destination);
       if(!trains.isEmpty()){
           responseStructureList.setStatusCode(HttpStatus.FOUND.value());
           responseStructureList.setMessgae("Trains are available ");
           responseStructureList.setData(trains);
           return responseStructureList;
       }
       else {
           responseStructureList.setStatusCode(HttpStatus.NOT_FOUND.value());
           responseStructureList.setMessgae("Trains are not available ");
           responseStructureList.setData(null);
           return responseStructureList;
       }
    }

    @Override
    public List<Train> findBySourceAndDestinationAndAvailableDate(String source, String destination, LocalDate date) {
       List<Train> trains=trainRepository.findBySourceAndDestinationAndAvailableDate(source,destination, date);
       if (!trains.isEmpty()){
          return trains;
       }
       else{
          throw new TrainNotFoundException("Tain is Not available with given details");
       }
    }


}
