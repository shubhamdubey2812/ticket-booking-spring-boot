package com.js.ticket_booking_spring_boot.utils;

import java.util.Random;

public class GeneratePnr {
    public static String generatePnr(){
        Random random=new Random();
        long pnr=random.nextLong(1_000_000_000L);
        pnr+=1_000_000_000L;
        return String.format("%010d",pnr);
    }
}
