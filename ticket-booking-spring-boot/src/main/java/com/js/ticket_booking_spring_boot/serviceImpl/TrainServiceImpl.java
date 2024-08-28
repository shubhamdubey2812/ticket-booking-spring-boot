package com.js.ticket_booking_spring_boot.serviceImpl;

import com.js.ticket_booking_spring_boot.entity.Train;
import com.js.ticket_booking_spring_boot.repository.TrainRepository;
import com.js.ticket_booking_spring_boot.response.ResponseStructure;
import com.js.ticket_booking_spring_boot.service.TrainService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TrainServiceImpl implements TrainService {
    @Autowired
    private TrainRepository trainRepository;
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private ResponseStructure<Train> responseStructure;
    @Override
    public ResponseStructure<Train> saveTrain(Train train) {
        if(httpSession.getAttribute("adminSession")!=null){
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
}
